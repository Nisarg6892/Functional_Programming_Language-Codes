datatype 'a ntree = leaf of 'a | node of 'a ntree list;

fun map(f,[]) = [] | 
	map(f, x::t) = f(x) :: map(f, t);

fun reduce(f,b,[]) = b |
	reduce(f,b,x::t) = f(x,reduce(f,b,t));


Control.Print.printDepth := 10;

fun subst(l, v1, v2) = let fun m_fun(leaf(x)) = if x=v1 then leaf(v2) else leaf(x) 
						|m_fun(node(y)) = node(map(m_fun, y))
						in
						m_fun(l)
						end;

fun toString(l) = let
	fun rfun(leaf(x),"") = x ^ ""
	| rfun(leaf(x),ans) = x ^ " " ^ ans
	| rfun(node(l),ans) = reduce(rfun,ans,l)
	in
		rfun(l,"")
	end;

subst(node([leaf("x"), node([leaf("y"), leaf("x"), leaf("z")])]),
     "x", "w");

toString(node([leaf("x"),node([leaf("y"),leaf("x"),leaf("z")])]));