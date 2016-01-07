datatype 'a inf_list = lcons of 'a * (unit -> 'a inf_list);

Control.Print.printDepth := 10;

fun church(y) = let fun thk() = church("(f "^ y^")")
			  in lcons("Lf.Lx. (f "^y^")", thk)
			  end;

fun take(0, inf_list) = []
	| take(n, lcons(h, thk)) = h :: take(n-1, thk());

take(5,church("x"))