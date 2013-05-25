package parse;
import java_cup.runtime.*;
%%

%class Lexer
%unicode
%cup
%line
%column
%public

%scanerror SyntaxError

%{
	private void report(String text){
		ErrorMessage.report(text, yyline + 1, yycolumn + 1);	
	}
	private void pos(String msg){
		System.out.println(msg + String.format(" line %d, column %d", yyline + 1, yycolumn + 1));
	}
	int comment_count = 0;
	private Symbol symbol(int type){
		return new Symbol(type, yyline, yycolumn);
	}

	private Symbol symbol(int type, Object value){
		return new Symbol(type, yyline, yycolumn, value);
	}

	private void error(String msg) throws SyntaxError{
		throw new SyntaxError(msg);
	}
%}

LineTerminator = \r|\n|\r\n
WhiteSpace = {LineTerminator} | [ \t\f]
Identifier = [a-z][a-z0-9]*
IntegerLiteral = [0-9]+


%state EOP
%state COMMENT

%%
<YYINITIAL> "::" {report(yytext());return symbol(sym.CONS);}
<YYINITIAL> "," {report(yytext());return symbol(sym.COMMA);}
<YYINITIAL> "(" {report(yytext());return symbol(sym.LPAREN);}
<YYINITIAL> ")" {report(yytext());return symbol(sym.RPAREN);}
<YYINITIAL> "=" {report(yytext());return symbol(sym.EQ);}
<YYINITIAL> ":=" {report(yytext());return symbol(sym.ASSIGN);}
<YYINITIAL> "->" {report(yytext());return symbol(sym.ARROW);}
<YYINITIAL> "+" {report(yytext());return symbol(sym.PLUS);}
<YYINITIAL> "-" {report(yytext());return symbol(sym.MINUS);}
<YYINITIAL> "*" {report(yytext());return symbol(sym.TIMES);}
<YYINITIAL> "/" {report(yytext());return symbol(sym.DIVIDE);}
<YYINITIAL> ">" {report(yytext());return symbol(sym.GT);}
<YYINITIAL> "<" {report(yytext());return symbol(sym.LT);}
<YYINITIAL> "~" {report(yytext());return symbol(sym.UMINUS);}
<YYINITIAL> ";" {report(yytext());return symbol(sym.SEMICOLON);}
<YYINITIAL> "fun" {report(yytext());return symbol(sym.FUN);}
<YYINITIAL> "let" {report(yytext());return symbol(sym.LET);}
<YYINITIAL> "in" {report(yytext());return symbol(sym.IN);}
<YYINITIAL> "end" {report(yytext());return symbol(sym.END);}
<YYINITIAL> "if" {report(yytext());return symbol(sym.IF);}
<YYINITIAL> "then" {report(yytext());return symbol(sym.THEN);}
<YYINITIAL> "else" {report(yytext());return symbol(sym.ELSE);}
<YYINITIAL> "while" {report(yytext());return symbol(sym.WHILE);}
<YYINITIAL> "do" {report(yytext());return symbol(sym.DO);}
<YYINITIAL> "nil" {report(yytext());return symbol(sym.NIL);}
<YYINITIAL> "fst" {report(yytext());return symbol(sym.FST);}
<YYINITIAL> "snd" {report(yytext());return symbol(sym.SND);}
<YYINITIAL> "head" {report(yytext());return symbol(sym.HEAD);}
<YYINITIAL> "tail" {report(yytext());return symbol(sym.TAIL);}
<YYINITIAL> "and" {report(yytext());return symbol(sym.AND);}
<YYINITIAL> "or" {report(yytext());return symbol(sym.OR);}
<YYINITIAL> "not" {report(yytext());return symbol(sym.NOT);}

<YYINITIAL> "true"|"false" {report(yytext());return symbol(sym.BOOLEAN, new Boolean(yytext()));}

<YYINITIAL> {Identifier} {report(yytext());return symbol(sym.ID, yytext());}
<YYINITIAL> {IntegerLiteral} {report(yytext());return symbol(sym.INT, new Integer(yytext()));}
<YYINITIAL> {WhiteSpace} {/*ignore*/}
<YYINITIAL> "$" {yybegin(EOP);}

<YYINITIAL> "/*"	{report("/*");yybegin(COMMENT);comment_count = 1;}

<COMMENT> {
	"/*"	{comment_count++;report("/*");}
	"*/"	{
					comment_count--;report("*/");
					if (comment_count == 0){
						yybegin(YYINITIAL);
					}
				}
	[^]	{/*ignore*/}
}

<EOP> {
	[^]	{}
}
<<EOF>> {
		if (yystate() == COMMENT){error("Comments are not closed!");}
		else if (yystate() != EOP){error("Program is incomplete!");}
		return symbol(sym.EOF);
}
