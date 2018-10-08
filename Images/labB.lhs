PROBLEM 6

>roots :: Int -> Int -> Int -> (Float,Float)
>roots x y z = if(d>=0)
>                   then (((-b) + sqrt(d)) / (2*a) , (((-b) - sqrt(d)) / (2*a)))
>					else error "No real roots\n"
>              where
>                   a = fromIntegral x
>                   b = fromIntegral y
>                   c = fromIntegral z
>                   d = b^2 - 4*a*c


>allRoots :: Int-> Int -> Int -> ((Float,Float),(Float,Float))
>allRoots x y z = if(d>=0)
>                      then ((((-b) + sqrt(d)) / (2*a),0) , ((((-b) - (sqrt(d))) / (2*a),0)))
>					   else ((-b/(2*a),sqrt(-d)/(2*a)) , ((-b/(2*a),-sqrt(-d)/(2*a))))
>                 where
>                      a = fromIntegral x
>                      b = fromIntegral y
>                      c = fromIntegral z
>                      d = b^2 - 4*a*c

PROBLEM 7

head [1..n] completed significantly faster regardless of the input.
tail [1..n] took just as long as [1..n] did to complete.
head (tail [1..n]) completed just as quickly as head[1..n]. Lazy evaluation is responsible for this behavior because it doesn't need to complete the entire tail to n, only the first element.


PROBLEM 8

>firstLast :: [a] -> [a]
>firstLast [] = error "empty list"
>firstLast x = tail (init x)

>strip :: Int -> [a] -> [a]
>strip n [] = error "empty list"
>strip n l = reverse (drop n (reverse (drop n l)))

>mrg :: [Int] -> [Int] -> [Int]
>mrg j [] = j
>mrg [] k = k
>mrg (x:xs) (y:ys) =
>      if x < y
>      then x : (mrg xs (y:ys))
>      else y : (mrg (x:xs) ys)


PROBLEM 9

Pattern		Argument			Succeeds		Bindings
1				1					yes		
2				1					no
x				1					yes			x = 1
x:y				[1,2]				yes			x = 1, y = [2]
x:y				[[1,2]]				yes			x = [1,2], y = []
x:y				"Bucknell"			yes			x = 'B', y = "ucknell"
x:y				["Bucknell"]		yes			x = "Bucknell", y = []
x:y:z			[1,2,3,4,5]			yes			x = 1, y = 2, z = [3,4,5]
x				[]					yes			x = []
[1,x]			[2,2]				no			
[]				[2,2]				no
(x,y)			[1,2,3,4]			no
((x:y),(z:w))	([1], "Bucknell")   yes			x=1,y=[],z='B',w="ucknell"

>tp ((x:y),(z:w)) = (x,y,z,w)
>testpat (x:y) = (x,y)
>testpat1 (x:y:z) = (x,y,z)

PROBLEM 10

1)

>addRat:: (Int,Int)->(Int,Int)->(Int,Int)
>addRat (_,0) (_,_)= error "Can't divide by zero!"
>addRat (_,_) (_,0)= error "Can't divide by zero!"
>addRat (a,b) (x,y)= reduce ((a*y)+(x*b),(y*b))
>reduce:: (Int,Int)->(Int,Int)
>reduce (x,y)= (x `div` z, y `div` z)
>				where
>				      z= gcd x y

2)

>mrg2 :: [Int] -> [Int] -> [Int]
>mrg2 j [] = j
>mrg2 [] k = k
>mrg2 (x:xs) (y:ys) =
>      if x < y
>      then x : (mrg2 xs (y:ys))
>      else y : (mrg2 (x:xs) ys)


PROBLEM 11

1)

The base case is when xs ==[]
The recursive case is when xs is not empty and the x is less than head of xs 

>sorted:: [Int]->Bool
>sorted (x:xs)= if xs /= [] &&  x <= head xs
>				   then sorted xs
>				   else 
>					   if xs == []
>				          then True
>						  else False



2)

The base case is when an empty list is passed to mySum.
The recursive case is when a non-empty list is passed to mySum.

>mySum:: [Int]->Int
>mySum []=0
>mySum (x:xs) = x+mySum xs   




