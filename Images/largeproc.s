# CSCI 206 Computer Organization & Programming
# Date: 2011-09-19
# Copyright (c) 2011 Bucknell University
#
# Permission is hereby granted, free of charge, to any individual or
# institution obtaining a copy of this software and associated
# documentation files (the "Software"), to use, copy, modify, and
# distribute without restriction, provided that this copyright and
# permission notice is maintained, intact, in all copies and
# supporting
# documentation.
#
# THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY
# KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE
# WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND
# NONINFRINGEMENT. IN NO EVENT SHALL BUCKNELL UNIVERSITY BE LIABLE FOR ANY
# CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT,
# TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH
# THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
#
#
# Student name: Caroline Whitman
#
# This program demonstrates passing a large number of arguments to a
# procedure which is not a leaf procedure.

	.data
	.align 2
A:	.word 3
B:	.word 7
C:	.word 4
D:	.word 9
E:	.word 3
F:	.word 8
Result1:.word 0xDEADBEEF
Result2:.word 0xDEADBEEF
newline:.asciiz "\n"

	.text

# The main() procedure calls largeProc, storing the results into
# Result1 and Result2 and also printing them out to the terminal.

# a0 - holds A 	(temp. used to store E on stack)
# a1 - holds B	(temp. used to store F on stack)
# a2 - holds C
# a3 - holds D
# v0 - used to do addition, values pushed onto stack
# v1 - used to do addition, values pushed onto stack

main:

# Prepare arguments to pass to largeProc

	lw 	$a0, E
	lw	$a1, F

	addi 	$sp, $sp, -8	# allocate space
	sw 	$a0, 4($sp)
	sw	$a1, 0($sp)
	
	lw	$a0, A
	lw	$a1, B
	lw	$a2, C
	lw	$a3, D
	
	jal 	largeProc
	addi	$sp, $sp 8	# deallocate space
# Call largeProc



# Print the results returned from largeProc
	move 	$a0, $v0 	# print first result
	li 	$v0, 1
	syscall
	
	la 	$a0, newline
	li	$v0, 4
	syscall
	
	move	$a0, $v1	# print second result
	li	$v0, 1
	syscall
	
	addi 	$sp, $sp, 20

# The program is finished. Terminate the execution.
	addi	$v0, $zero, 10		# system call for exit
	syscall

# This large complicated procedure takes 6 paramters and returns 2.
# Additionally this procedure calls another procedure.
# It is assumed that $fp has been set correctly

largeProc:

# your code goes here

	lw	$t0, 4($sp)	# store E (p4) in $t0
	lw	$t1, 0($sp)	# store F (p5) in $t1
	
	
	add	$v0, $a1, $a2	# $v0 = p1 + p2
	add	$v0, $v0, $t0	# $v0 = $v0 + p4
	
	mul 	$v1, $a3, -1	# $v1 = -p3
	add	$v1, $v1, $a0	# $v1 = p0 + -p3 = p0 - p3
	add	$v1, $v1, $t1	# $v1 = p0 - p3 + p5
	
	addi 	$sp, $sp, -12	# allocate space 
	
	sw	$v0, 0($sp)	# store $v0 on the stack
	sw 	$v1, 4($sp)	# store $v1 on the stack
	sw	$ra, 8($sp)	# store the return address
	
	jal smallProc
	
	lw 	$ra, 8($sp)	# pop $ra from stack
	
	lw	$v0, 0($sp)	# pop $v0 from stack
	lw	$v1, 4($sp)	# pop $v1 from stack
	
	addi 	$sp, $sp, 12	# deallocate space
	
	
	
	# Store registers which must be saved onto the stack

	# Compute the first result

	# Compute the second result

	# Call smallProc for the heck of it, but save $v0,
	# and $v1 because smallProc could possibly overwrite them!

	# Restore registers using the stack

	jr	$ra

# This procedure computes nothing useful, it just returns

smallProc:

	jr	$ra
		
# If you have 3 word sized integer values, you'd have to push the third return value onto the stack,
# return the other two, and then pop the last return value off the stack to return it.
