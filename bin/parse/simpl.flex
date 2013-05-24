package parse;
import java_cup.runtime.*;
%%

%class Lexer
%unicode
%cup
%line
%column

%{
	private Symbol symbol(int type){
		return new Symbol(type, yyline, yycolumn);
	}

	private Symbol symbol(int type, Object value){
		return new Symbol(type, yyline, yycolumn, value);
	}

	private void error(String msg){
		System.out.println(msg);
	}
%}

LineTerminator = \r|\n|\r\n
WhiteSpace = {LineTerminator} | [\t\f]
Identifier = [a-z][a-z0-9]*
IntegerLiteral = [0-9]+

/* comments */
Comment = "/*" [^]* "*/"

%state EOP

%%
<YYINITIAL> "::" {return symbol(sym.CONS);}
<YYINITIAL> "," {return symbol(sym.COMMA);}
<YYINITIAL> "(" {return symbol(sym.LPAREN);}
<YYINITIAL> ")" {return symbol(sym.RPAREN);}
<YYINITIAL> "=" {return symbol(sym.EQ);}
<YYINITIAL> ":=" {return symbol(sym.ASSIGN);}
<YYINITIAL> "->" {return symbol(sym.ARROW);}
<YYINITIAL> "+" {return symbol(sym.PLUS);}
<YYINITIAL> "-" {return symbol(sym.MINUS);}
<YYINITIAL> "*" {return symbol(sym.TIMES);}
<YYINITIAL> "/" {return symbol(sym.DIVIDE);}
<YYINITIAL> ">" {return symbol(sym.GT);}
<YYINITIAL> "<" {return symbol(sym.LT);}
<YYINITIAL> "~" {return symbol(sym.UMINUS);}
<YYINITIAL> ";" {return symbol(sym.SEMICOLON);}
<YYINITIAL> "fun" {return symbol(sym.FUN);}
<YYINITIAL> "let" {return symbol(sym.LET);}
<YYINITIAL> "in" {return symbol(sym.IN);}
<YYINITIAL> "end" {return symbol(sym.END);}
<YYINITIAL> "if" {return symbol(sym.IF);}
<YYINITIAL> "then" {return symbol(sym.THEN);}
<YYINITIAL> "else" {return symbol(sym.ELSE);}
<YYINITIAL> "while" {return symbol(sym.WHILE);}
<YYINITIAL> "do" {return symbol(sym.DO);}
<YYINITIAL> "nil" {return symbol(sym.NIL);}
<YYINITIAL> "fst" {return symbol(sym.FST);}
<YYINITIAL> "snd" {return symbol(sym.SND);}
<YYINITIAL> "head" {return symbol(sym.HEAD);}
<YYINITIAL> "tail" {return symbol(sym.TAIL);}
<YYINITIAL> "and" {return symbol(sym.AND);}
<YYINITIAL> "or" {return symbol(sym.OR);}

<YYINITIAL> "true"|"false" {return symbol(sym.BOOLEAN, new Boolean(yytext()));}

<YYINITIAL> {Identifier} {return symbol(sym.ID, yytext());}
<YYINITIAL> {IntegerLiteral} {return symbol(sym.INT, new Integer(yytext()));}
<YYINITIAL> {Comment} {/*ignore*/}
<YYINITIAL> {WhiteSpace} {/*ignore*/}
<YYINITIAL> "$" {yybegin(EOP);}

<EOP> {
	[^]	{}
}
<<EOF>> {
		if (yystate() != EOP){error("Program is incomplete!");}
		return symbol(sym.EOF);
}
