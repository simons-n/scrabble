# Student name: Cristal Hermosillo
# CSCI 206 Lab 05 8am
#2/23/2016
.data
array:
.space 400

square:
.asciiz "squares["

squareEnding:
.asciiz "]= "

newLine:
.asciiz "\n"

sumPrint:
.asciiz "Sum of squares from 0 to 99 = "

iCount:
.word 0 			# int i

sum:
.word 0 			# int sum

.text
main:				# This symbols marks the first instruction of your program
	li $s1, 0	#sum 
	sw $s1, sum
	li $s3,0	#i counter
	sw $s3, iCount
	move $t0, $zero
		 
test:
	bgt	$s3, 99, end
	mul     $t2, $s3, $s3	
	add	$s1, $s1, $t2
	sw 	$t2, array($t0)
	jal      print
	addi	$s3, $s3, 1
	addi	$t0, $t0, 4
	j	test

print:
	li  $v0, 4
	la  $a0 , square
	syscall
	li $v0, 1
	add $a0, $s3, $zero
	syscall 
	li  $v0, 4
	la  $a0 , squareEnding
	syscall
	li $v0, 1
	add $a0, $t2, $zero
	syscall
	li 	$v0, 4
	la 	$a0, newLine
	syscall
	jr  	$ra
	
	

end:
	li  $v0, 4
	la  $a0 , sum
	syscall
	li $v0, 1
	add $a0, $s1, $zero
	syscall
	li	$v0, 10		# system call for exit
	syscall			# Exit!