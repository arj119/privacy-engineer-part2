lexer grammar PELexer;

WHITESPACE: [ \n\r\t] -> skip;

// operators
MUL: '*';
ADD: '+';
MINUS: '-';
EQUALS: '=';

// keywords
BGW: 'BGW';
FUNCTION: 'f';
CONFIG: 'config';
SECRET: 'secret';
COEFF: 'coeff';



OPEN_PARENTHESIS: '(' ;
CLOSE_PARENTHESIS: ')' ;

COMMA: ',';
IDENT: ('a'..'z' | 'A'..'Z')('0'..'9' | 'a'..'z' | 'A'..'Z' | '_')* ;

fragment CHARACTER: ~('\\' | '\'' | '"') | '\\' ESCAPED_CHAR;
fragment ESCAPED_CHAR: ('0' | 'b' | 't' | 'n' | 'f' | 'r' | '"' | '\'' | '\\');
fragment DIGIT: '0'..'9' ;
NUMBER: DIGIT+;
CHAR_LITER:'\'' CHARACTER '\'';
