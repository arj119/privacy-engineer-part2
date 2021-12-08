parser grammar PEParser;

options {
  tokenVocab=PELexer;
}

program: configuration function EOF;

function: FUNCTION '(' param_list ')' '=' expr;

param_list: IDENT (COMMA IDENT)*;

expr: IDENT                                                         #Identifier
    | left=expr ADD right=expr                                      #AddExpression
    | left=expr MUL right=expr                                      #MulExpression
    | OPEN_PARENTHESIS expr CLOSE_PARENTHESIS                       #BracketedExpression
    ;

configuration: CONFIG '(' config_param_list ')';

config_param_list: config_param (COMMA config_param)*;

config_param: ident=IDENT '(' SECRET '=' secret=NUMBER COMMA COEFF '=' coeff=NUMBER ')';