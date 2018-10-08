# Jack Napor - Solution Architect
# Nick Simons - Software Engineer
# Keller Chambers - Quality Control
# Instruction Count for Fib(n) = O(2^n)
# Stack size for Fib(n) = O(2^n)

.text

li $a0, 4
jal fib
move $a0, $v0
li $v0, 1
syscall

li $v0, 10
syscall



fib:
	addi $sp, $sp, -12
	addi $t7, $zero, 1
	sw $ra, 4($sp)
	sw $a0, 0($sp)
	
	beq $a0, $zero, return0
	beq $a0, $t7, return1
	
final:
	addi $a0, $a0, -1
	jal fib
	sw $v0, 8($sp)
	addi $a0, $a0, -1
	jal fib
	lw $a0, 0($sp)
	lw $ra, 4($sp)
	lw $t4, 8($sp)
	addi $sp, $sp, 12
	add $v0,$v0,$t4
	jr $ra
return0:
	addi $v0, $zero, 0
	addi $sp, $sp, 12
	jr $ra
	
return1:
	addi $v0, $zero, 1
	addi $sp, $sp, 12
	jr $ra
