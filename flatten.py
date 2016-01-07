# <----------------------2(a)---------------------->

# From the below definition of mystery function discussed in lecture
#
#     fun mystery([ ]) = []
#     | mystery(h::t) = h @ mystery(t)
#
# We are concatenating element h with the remaining list t.
#
# So h should always to be a single level list, so if we are going to define funtion for 3 level list (using this 2 level mystery function) then that function will only work for 3 level list.
# Similarly n-level function will only work for n level list.
#
# What does prevent us from writing a generic type of list where components of the given list can be of n-level list :
#
# As ML is statically typed language, we need to define the type of the argument beforehand and we can't know the type of the argument at runtime.
# That's the reason it can't handle the generic case. If we know the multilevel list beforehand then we might possibly write
# a hardcoded function for it but it will only work for that case. If ML would have supported operations like isinstance or instanceOf as in Python
# then it could have been possible but as ML is statically typed language it is not allowed.


# <----------------------2(b)---------------------->


# import collections

l = [[[1],[2]],[[3]],[[4,5],[6]]]

def flatten(given_list):
	for element in given_list:
		# if isinstance(element, collections.Iterable) and not isinstance(element, basestring):
		if isinstance(element, list):
			for sublist in flatten(element):
				yield sublist
		else:
			yield element

print [x for x in flatten(l)]