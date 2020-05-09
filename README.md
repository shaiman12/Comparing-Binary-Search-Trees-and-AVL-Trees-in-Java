# Comparing-Binary-Search-Trees-and-AVL-Trees-in-Java
This was a computer science data structures assignment where I had to compare the speeds and efficiency of Binary Search Trees and AVL trees - implemented in Java

# Part	1:	Object	Orientated	design	and	interaction	of	experiment

Use	of	generics	throughout	and	giving	
credit	where	it	is	due:
In	designing	the	OOP	structure	of	the	
binary	search	tree	and	AVL	tree	I	decided	
to	use	generics	throughout	so	that	I	could	
use	these	classes	in	later	projects	that	
may	require	me	to	use	a	binary	search	
tree	or	and	AVL	tree	with	objects	that	are	
not	‘Item’	objects.	Furthermore,	I	have	
adapted	the	code	for	the	binary	search	
tree	and	AVL	tree	from	both	the	slides	
provided	by	UCT		
and	the	textbook	called	‘Data	Structures	
and	Problem	Solving	Using	Java’

## The	Item	Class
This	is	the	class	that	is	used	to	store	the	
information	about	an	individual	object	of	
the	time	series	of	power	usage	for	a	
suburban	dwelling.	This	stores	
information	such	as	the	date	that	it	was	
recorded,	the	global	active	power	and	the	amount	of	voltage	used.	It	has	both	
accessor	and	mutator	methods	for	receiving	and	changing	the	specific	
information	about the	3	indicated	instance	variables.	It	also	has	toString	method	
(which	would	be	used	by	other	classes	as	I	will	indicate	below)	that	returns	the	
date/time,	power	and	voltage	of	a	specific	object	in	a	neatly	organized	string.	It	
has	a	compareTo	function,	which	will	compare	the	date/time	strings	of	two	Item	
objects.

## The	BinaryTreeNode<dataType>	class
This	class	stores	a	private	generic	data	type	that	will	hold	the	object	that	is	being	
stored	in	the	binary	search	tree	or	AVL	tree.	It	also	stores	the	reference	variables	
to	the	left	and	right	sub-nodes	(which	are	given	package	access	privacy	modifier	
status).	This	also	stores	the	height	of	a	particular	node	relative	to	its	position	in	
the	tree.	It	has	a	parameterized	constructor	that	stores	the	necessary	
information	in	the	instance	variables.	It	has	accessor	and	mutator	methods	for	
the	left	and	right	sub-trees.	It	has	a	toString	method	that	returns	the	data	item	
that	it	is	storing’s	toString	(i.e.	it	returns	data.toString()).	In	the	case	of	this	
project	the	data variable	will	hold	an	‘Item’	object	and	it	will	be	able	to	use	the	
‘Item’	objects	toString	method	that	returns	the	data	necessary	to	be	returned	as	
defined	in	the	powerBSTApp	and	powerAVLApp,	which	will	be	shown	below.


## BinarySearchTree<dataType>	class
This	class	serves	as	the	typical	binary	search	tree	class.	I	will	only	be	highlighting	
the	methods	that	are	used	by	this	practical,	as	there	are	other	methods	I	have	
added	for	fun.	It	has	a	private	instance	variable	of	type	
BinaryTreeNode<dataType>	that	stores	the	root	node	of	the	binary	search	tree	
data	structure.	It	also	has	an	integer	instance	variable	called	opCount,	which	
stores	the	amount	of	comparison	operations	that	occurs	when	a	search	is	
invoked	from	the	PowerBSTApp.	It	also	has	an	integer	instance	variable	called	
opCountSearch,	which	stores an	incremental	count	of	the	comparison	operations	
when	a	subset	size	of	the	input	data	is	inserted	from	the	PowerBSTApp.	It	has	a	
constructor,	which	simply	sets	the	root	node	to	null,	and	both	the	opCountInsert
and	opCount	to	zero.	It	has	a	very	important	method,	which	is	critical	in	the	
output	of	this	practical	called	visit.	This	method	receives	a	node	in	the	binary	
search	tree	and	returns	a	substring	of	the	first	19	letters	of	the	toString	of	the	
node.	The	reason	that	I	used	a	substring	was	so	that	in	traversals	of	the	tree,	only	
the	date/time	is	displayed	– as	is	required	by	the	printAllDateTimes	method	in	
the	PowerBSTApp	and	for	comparison	operations	used	in	searching	(so	that	it	is	
in	the	form:	dd/mm/yyyy/hh/mm/ss).	The	insert	method	is	typical	of	any	
binary	search	tree	implementation	and	there	is	nothing	noteworthy	here,	
besides	updating	the	opCountInsert,	it	merely	just	inserts	an	item	into	the	binary	
search	tree.	The	find	method	here	receives	a	string	that in	this	practical	will	be	a	
specific	date/time	that	is	being	searched	for.	It	also	uses	a	substring	of	the	first	
19	letters	of	the	node	(that	is	passed	as	an	argument	to	the	method)	to	compare	
to	the	search	term.	The	find	method	also	updates	the	opCount	instance	variable	
every	time	a	comparison	operation	is	completed.	The	Binary	search	tree	also	has	
an	inOrder	traversal,	which	visits	each	node	in	the	tree	in	a	sorted	manner.

## AVLTree<dataType>	class
This	class	serves	as	the	typical	AVL	tree	class.	I	will	only	be	highlighting	the	
methods	that	are	used	by	this	practical.	It	has	a	private	instance	variable	of	type	
BinaryTreeNode<dataType>	that	stores	the	root	node	of	the	binary	search	tree	
data	structure.	It	also	has	an	integer	instance	variable	called	opCount,	which	
stores	the	amount	of	comparison	operations	that	occurs	when	a	search	is	
invoked	from	the	PowerAVLApp.	It	also	has	an	integer	instance	variable	called	
opCountSearch,	which	stores	an	incremental	count	of	the	comparison	operations	
when	a	subset	size	of	the	input	data	is	inserted	from	the	PowerAVLApp.	It	has	a	
constructor,	which	simply	sets	the	root	node	to	null,	and	both	the	opCountInsert	
and	opCount	to	zero.	It	has	a	very	important	method,	which	is	critical	in	the	
output	of	this	practical	called	visit.	This	method	receives	a	node	in	the	AVL	tree	
and	returns	a	substring	of	the	first	19	letters	of	the	toString	of	the	node.	The	
reason	that	I	used	a	substring	was	so	that	in	traversals	of	the	tree,	only	the	
date/time	is	displayed	– as	is	required	by	the	printAllDateTimes	method	in	the	
PowerAVLApp	and	for	comparison	operations	used	in	searching	(so	that	it	is	in	
the	form:	dd/mm/yyyy/hh/mm/ss).	The	insert	method	is	typical	of	any	AVL	tree	
implementation,	it	does	the	same	insertion	operation	as	a	binary	search	tree,	
however	it	calls	the	balance	function	at	the	end	of	it	to	rebalance	the	tree. The	
balance	method	uses	another	method	called	balancefactor	which	will	determine	
the	height	difference	between	the	left	and	right	subtrees	of	any	node.	The	
balance	method	also	uses	the	rotateLeft	and	rotateRight	methods	which	will	allow	the	tree	to	become	balanced	and	fulfill	the	AVL	tree	criteria. The	find	
method	here	receives	a	string	that	in	this	practical	will	be	a	specific	date/time	
that	is	being	searched	for.	It	also	uses	a	substring	of	the	first	19	letters	of	the	
node	(that	is	passed	as	an	argument	to	the	method)	to	compare	to	the	search	
term.	The	find	method	also	updates	the	opCount	instance	variable	every	time	a	
comparison	operation	is	completed.	The	Binary	search	tree	also	has	an	inOrder	
traversal,	which	visits	each	node	in	the	tree	in	a	sorted	manner.

## How	the	user	will	interact	with	PowerAVLApp	and	PowerBSTApp
In	both	the	PowerAVLApp	and	PowerBSTApp	
when	it	is	run	with	no	arguments	the	following	
menu	is	provided	for	the	user	to	choose	what	
to	do	with	the	app.	It	should	also	be	noted	that	
when	performing	tests	the	user	should	change	the	data	that	is	being	inserted	
into	the	program	in	accordance	to	what	test	is	being	done.	I	have	made	two	
directories	called:	sortedTexts	and	unsortedTexts.	The	files	here	simply	need	to	
be	copied	into	the	bin	directory	depending	on	what	test	needs	to	be	done:	one	
that	is	testing	sorted	data	or	one	that	is	testing	unsorted	data.

## PowerAVLApp	class
This	is	an	application	that	has	many	methods.	This	class’s	function	is	to	serve	as	
a	user	interface	that	will	provide	a	user	the	opportunity	to	do	the	following via	a	
provided	menu:
1)	Conduct	tests	on	an	AVL	tree
2)	Print	out	all	data	in	an	AVL	tree
3)	Search	for	specific	data	in	an	AVL	tree
The	user	will	interact	with	the	application	through	the	shell	- using	the	prompts	
provided	for	the	user	defined	in	this	class	as	shown	above.	This	stores	a	static	
instance	variable	x	which	holds	the	AVL	tree	itself.	This	stores	an	array	of	
operation	counts	for	searches,	from	which	can	be	used	to	find	the	best,	average	
and	maximum	amount	of	operations	depending	on	input	size	of	data.	The	
printAllDateTimes	method	returns	a	string	output	of	all	the	date/times	stored	in	
the	AVL	tree	of	‘Item’	objects	using	the toString method	defined	in	the	AVL	tree	
class. The	printDateTime	method	receives	a	String	argument	in	the	form	of	a	
specific	date/time	that	the	user	is	looking	and	returns	a	string	with	the	
information	relating	to	that	specific	date/time	using	the	toString	method	defined	
in	the	Item	class	by	using	the	find	method	in	the	AVLTree	class.	There	is	a	
method	called	build	that	builds	an	AVL	tree	of	size	n	(provided	as	an	argument	to	
it).	It	scans	through	the	file	cleaned_data.csv	and	creates	'Item'	objects	to	be	
stored	in	the	AVL	tree	- This	uses	2	scanners:	1	for	lines	in	the	file	and	1	for	data	
in	a	line. There	is	a	method	called	subsetSeach	that	searches	through	an	AVL	tree	
using	values	provided	by	FileWithSearchKeys.txt.	It	will	store	the	search	
operation	count	results	in	the	opCountSearch	array.	There	are	methods	called	
getBest,	getWorst	and	getAve	which	all	find	the	best,	worst	and	average	case	of	
operation	counts	for	a	particular	subset.	There	is	a	method	called	writer	that
writes	the	results	(insertion	counts,	best,	average,	worst	case)	to	the	file	
outputAVL.csv.	There	is	also	the	main	method	which	will	provide	the	user	with	a	
menu	and	call	the	respective	methods	when	needed.


## PowerBSTApp	class
This	is	an	application	that	has	many	methods.	This	class’s	function	is	to	serve	as	
a	user	interface	that	will	provide	a	user	the	opportunity	to	do	the	following	via	a	
provided	menu:
1)	Conduct	tests	on	a	binary	search	tree
2)	Print	out	all	data	in	a	binary	search	tree
3)	Search	for	specific	data	in	a	binary	search	tree
The	user	will	interact	with	the	application	through	the	shell	- using	the	prompts	
provided	for	the	user	defined	in	this	class	as	shown	above.	This	stores	a	static	
instance	variable	x,	which	holds	the	binary	search	tree	itself.	This	stores	an	array	
of	operation	counts	for	searches,	from	which	can	be	used	to	find	the	best,	
average	and	maximum	amount	of	operations	depending	on	input	size	of	data.	
The	printAllDateTimes	method	returns	a	string	output	of	all	the	date/times	
stored	in	the	AVL	tree	of	‘Item’	objects	using	the	toString method	defined	in	the	
AVL	tree	class. The	printDateTime	method	receives	a	String	argument	in	the	
form	of	a	specific	date/time	that	the	user	is	looking	and	returns	a	string	with	the	
information	relating	to	that	specific	date/time	using	the	toString	method	defined	
in	the	Item	class	by	using	the	find	method	in	the	BinarySearchTree	class.	There	is	
a	method	called	build	that	builds	a	binary	search	tree	of	size	n	(provided	as	an	
argument	to	it).	It	scans	through	the	file	cleaned_data.csv	and	creates	'Item'	
objects	to	be	stored	in	the	binary	search	tree	- This	uses	2	scanners:	1	for	lines	in	
the	file	and	1	for	data	in	a	line.	There	is	a	method	called	subsetSeach	that	
searches	through	a	binary	search	tree	using	values	provided	by	
FileWithSearchKeys.txt.	It	will	store	the	search	operation	count	results	in	the	
opCountSearch	array.	There	are	methods	called	getBest,	getWorst	and	getAve,	
which	all	find	the	best,	worst	and	average	case	of	operation	counts	for	a	
particular	subset.	There	is	a	method	called	writer	that writes	the	results	
(insertion	counts,	best,	average,	worst	case)	to	the	file	outputBST.csv.	There	is	
also	the	main	method,	which	will	provide	the	user	with	a	menu	and	call	the	
respective	methods	when	needed.

# Part	2:	Goal	of	Experiment	and	Method	of	Execution
The	Goal
The	goal	of	this	experiment	was	to	use	the	above	OOP	design	to	demonstrate	the	
speed	differences	when	performing	a	search	and	insertion	of	a	specified	amount	
of	data	between	a	binary	search	tree	and	an	AVL	tree.	The	test	shows	which	data	
structure	may	be	more	efficient	when	we	vary	the	size	of	the	dataset	(N).	

The	Execution
In	order	to	do	this	test	effectively	and	efficiently	I	decided	to	use	the	class	
infrastructure	that	I	have	described	above.	The	testing	was	done	in	both	the	
PowerBSTApp	and	PowerAVLApp	classes.	I	used	the	methods	I	described	in	part	
1	above	to	do	the	testing,	the	algorithm	that	I	used	did	the	following:

- The	programs	iterated	500	times	so	that	each	record	will	be	created	to	make	
    a	new	subset	of	the	entire	data	provided	to	us	(i.e.	a	new	N)
       o For	each	iteration	two	empty	arrays	are	created
       o The	program	builds	either	a	BST/AVL	tree	of	size	N
         ! Insertion	counts	are	counted	and	recorded	
       o The program	reads	through	the ‘cleaned_data.csv’	file up	to	line	N.	


```
! For	every	line	it	iterates	through,	a	search	is	performed	by	
using	the	command	line	entry	as	defined	in	the	PowerAVLApp	
and	PowerBSTApp.	
! The	operation	counts	are	added	to	the	empty	arrays
o Once	the	program	has	iterated	through	each	line	the	best	case,	
average	case	and	worst	case	for	both	the	binary	search	tree and	AVL	
tree implementation.
o It	records	the	insertion	count,	the	best	case,	the	average	case	and	the	
worst	case	in	csv	files	called	outputBST.csv	and	outputAVL.csv
```
