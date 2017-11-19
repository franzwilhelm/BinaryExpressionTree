# Binary expresion tree

Implementation in java of a binary expression tree, written by me and [@eirikhalvard](https://github.com/eirikhalvard), 
using atom's new plugin [Teletype](https://teletype.atom.io/), for real time collaboration (check it out!)

## How it works

A [binary expression tree](https://en.wikipedia.org/wiki/Binary_expression_tree) is a binary tree representation of mathematical 
expressions, which make it easier to translate an input expression to an actual answer.

Consider this example, with input of `-2*7-4^2`. 

![Tree](http://www.101computing.net/wp/wp-content/uploads/algebric-expression-tree-2.png)

To compose this tree our algorithm searches for the least significant operator 
(based on [order of operations](https://en.wikipedia.org/wiki/Order_of_operations)), 
and divides the calculation into two subparts. This process is repeated recursively, always pivoting by the least
significant operator. In later versions, where we may add support for parentheses, the parentheses would be generated as smaller
individual trees that would be solved first, passing the result as a digit to the rest of the tree for further processing.

## Roadmap

The plan is trying to implement more functionality to the tree, making it a useful and fast math tool, for use in any terminal.
After implementing basic functions mentioned underneath, we may move into the world of linear algebra, and all that entails...

#### General
- [ ] Negative numbers
- [ ] Parenthesis

#### Basic operators
- [x] + - / * ^
- [ ] sqrt
- [ ] ln
- [ ] log10

#### Trigonometric functions
- [x] sin, cos, tan
- [ ] arcsin, arccos, arctan
- [ ] sinh, cosh, tanh
- [ ] cot, csc, sec

#### Constants
- [ ] pi
- [ ] e
- [ ] the imaginary unit i
