grammar Hello;
import Keyword;

r : HELLO ID; // match keyword hello followed by an identifier
ID : [a-z]+; // match lower-case identifiers
WS : [ \t\r\n]+ -> skip;