# Nick Simons
# 2/23/16 3pm
# lab06 collatz.s
#
# data segment ------------------------------------------------
.data
.align 2
arrow:
.asciiz "==>"

newline:
.asciiz "\n"

MAX_ITEMS:
.word 100

# code segment ------------------------------------------------
.text
init:
	li $s0, 100
	sw $s0, MAX_ITEMS
	addi $t0, $zero, 1
	move $v0, $zero
	addi $sp, $sp, -8
	
####################### MAIN
main:
	move $a0, $zero
	move $a1, $zero
	
	bge $t0, $s0, terminatemain	#stop loop if i >= MAX_ITEMS
	
	li $v0, 1		# print i
	move $a0, $t0
	syscall
	
	li $v0, 4   		# print the arrow
	la $a0, arrow
	syscall

	move $a0, $t0		# put the value of i into the argument 
				# variable for find_length

	sw $a1, 4($sp)		#pushin stuff onto the stack yeah
	jal set_ra		# jumpin to shit
	lw $a1, 4($sp)
	
	li $v0, 1		#printing the fuck outta this length
	move $a0, $a1
	syscall
	
	li $v0, 4		#adding a newline fuck yeah
	la $a0, newline
	syscall
	
	addi $t0, $t0, 1	#incrementing i
	j main		        #looping
terminatemain:
	addi $sp, $sp, 12	#de-allocate stack
	
	li $v0, 10		#exit!
	syscall
####################### MAIN
####################### COLLATZ
collatz:
	beq $a0, 1, basecollatz	
	div $t7, $a0, 2
	mfhi $t6
	mflo $t5
	beq $t6, 0, even
	mul $t4, $a0, 3
	addi $t4, $t4, 1
	move $v1, $t4
	jr $ra
basecollatz:
	move $v1, $zero
	jr $ra
even:
	move $v1, $t5
	jr $ra
####################### COLLATZ
####################### FIND_LENGTH
set_ra:
	sw $ra, 0($sp)
find_length:

	beq $a0, 1, basefl
	lw $v0, 4($sp)
	addi $v0, $v0, 1
	sw $v0, 4($sp)
	
	jal collatz
	move $a0, $v1
	j find_length
basefl:
	lw $v0, 4($sp)
	addi $v0, $v0, 1
	sw $v0, 4($sp)
	lw $ra, 0($sp)
	jr $ra
####################### FIND_LENGTH
