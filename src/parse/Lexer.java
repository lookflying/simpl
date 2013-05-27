/* The following code was generated by JFlex 1.4.3 on 5/27/13 5:31 PM */

package parse;
import java_cup.runtime.*;
import run.ErrorMessage;

/**
 * This class is a scanner generated by 
 * <a href="http://www.jflex.de/">JFlex</a> 1.4.3
 * on 5/27/13 5:31 PM from the specification file
 * <tt>simpl.flex</tt>
 */
public class Lexer implements java_cup.runtime.Scanner {

  /** This character denotes the end of file */
  public static final int YYEOF = -1;

  /** initial size of the lookahead buffer */
  private static final int ZZ_BUFFERSIZE = 16384;

  /** lexical states */
  public static final int YYINITIAL = 0;
  public static final int COMMENT = 4;
  public static final int EOP = 2;

  /**
   * ZZ_LEXSTATE[l] is the state in the DFA for the lexical state l
   * ZZ_LEXSTATE[l+1] is the state in the DFA for the lexical state l
   *                  at the beginning of a line
   * l is of the form l = 2*k, k a non negative integer
   */
  private static final int ZZ_LEXSTATE[] = { 
     0,  0,  1,  1,  2, 2
  };

  /** 
   * Translates characters to character classes
   */
  private static final String ZZ_CMAP_PACKED = 
    "\11\0\1\3\1\2\1\0\1\3\1\1\22\0\1\3\3\0\1\41"+
    "\3\0\1\10\1\11\1\16\1\15\1\7\1\13\1\0\1\17\12\5"+
    "\1\6\1\22\1\20\1\12\1\14\42\0\1\37\2\4\1\32\1\27"+
    "\1\23\1\4\1\33\1\31\2\4\1\26\1\4\1\25\1\36\2\4"+
    "\1\40\1\34\1\30\1\24\1\4\1\35\3\4\3\0\1\21\uff81\0";

  /** 
   * Translates characters to character classes
   */
  private static final char [] ZZ_CMAP = zzUnpackCMap(ZZ_CMAP_PACKED);

  /** 
   * Translates DFA states to action switch labels.
   */
  private static final int [] ZZ_ACTION = zzUnpackAction();

  private static final String ZZ_ACTION_PACKED_0 =
    "\3\0\2\1\1\2\1\3\1\0\1\4\1\5\1\6"+
    "\1\7\1\10\1\11\1\12\1\13\1\14\1\15\1\16"+
    "\1\17\14\2\1\20\1\21\2\1\1\22\1\23\1\24"+
    "\1\25\13\2\1\26\1\27\1\30\3\2\1\31\1\2"+
    "\1\32\1\33\1\34\1\35\1\2\1\36\1\37\1\40"+
    "\1\41\5\2\1\42\1\2\1\43\1\44\1\45\1\46"+
    "\1\47\1\50\1\2\1\51";

  private static int [] zzUnpackAction() {
    int [] result = new int[83];
    int offset = 0;
    offset = zzUnpackAction(ZZ_ACTION_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAction(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /** 
   * Translates a state to a row index in the transition table
   */
  private static final int [] ZZ_ROWMAP = zzUnpackRowMap();

  private static final String ZZ_ROWMAP_PACKED_0 =
    "\0\0\0\42\0\104\0\146\0\210\0\252\0\314\0\356"+
    "\0\210\0\210\0\210\0\210\0\u0110\0\210\0\210\0\210"+
    "\0\u0132\0\210\0\210\0\210\0\u0154\0\u0176\0\u0198\0\u01ba"+
    "\0\u01dc\0\u01fe\0\u0220\0\u0242\0\u0264\0\u0286\0\u02a8\0\u02ca"+
    "\0\210\0\210\0\u02ec\0\u030e\0\210\0\210\0\210\0\210"+
    "\0\u0330\0\u0352\0\u0374\0\u0396\0\u03b8\0\u03da\0\u03fc\0\u041e"+
    "\0\u0440\0\u0462\0\u0484\0\252\0\252\0\252\0\u04a6\0\u04c8"+
    "\0\u04ea\0\252\0\u050c\0\210\0\210\0\252\0\252\0\u052e"+
    "\0\252\0\252\0\252\0\252\0\u0550\0\u0572\0\u0594\0\u05b6"+
    "\0\u05d8\0\252\0\u05fa\0\252\0\252\0\252\0\252\0\252"+
    "\0\252\0\u061c\0\252";

  private static int [] zzUnpackRowMap() {
    int [] result = new int[83];
    int offset = 0;
    offset = zzUnpackRowMap(ZZ_ROWMAP_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackRowMap(String packed, int offset, int [] result) {
    int i = 0;  /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int high = packed.charAt(i++) << 16;
      result[j++] = high | packed.charAt(i++);
    }
    return j;
  }

  /** 
   * The transition table of the DFA
   */
  private static final int [] ZZ_TRANS = zzUnpackTrans();

  private static final String ZZ_TRANS_PACKED_0 =
    "\1\0\1\4\2\5\1\6\1\7\1\10\1\11\1\12"+
    "\1\13\1\14\1\15\1\16\1\17\1\20\1\21\1\22"+
    "\1\23\1\24\1\25\1\6\1\26\1\27\1\30\1\31"+
    "\1\32\1\33\1\34\1\35\1\36\1\37\1\40\1\6"+
    "\1\41\42\42\16\5\1\43\1\44\22\5\2\0\1\5"+
    "\105\0\2\6\15\0\16\6\6\0\1\7\42\0\1\45"+
    "\3\0\1\46\43\0\1\47\43\0\1\50\27\0\2\6"+
    "\15\0\1\6\1\51\7\6\1\52\2\6\1\53\1\6"+
    "\5\0\2\6\15\0\6\6\1\54\4\6\1\55\2\6"+
    "\5\0\2\6\15\0\4\6\1\56\11\6\5\0\2\6"+
    "\15\0\2\6\1\57\1\60\12\6\5\0\2\6\15\0"+
    "\10\6\1\61\3\6\1\62\1\63\5\0\2\6\15\0"+
    "\1\64\1\6\1\65\13\6\5\0\2\6\15\0\13\6"+
    "\1\66\2\6\5\0\2\6\15\0\4\6\1\67\11\6"+
    "\5\0\2\6\15\0\2\6\1\70\13\6\5\0\2\6"+
    "\15\0\10\6\1\71\5\6\5\0\2\6\15\0\15\6"+
    "\1\72\5\0\2\6\15\0\2\6\1\73\13\6\20\0"+
    "\1\74\40\0\1\75\27\0\2\6\15\0\2\6\1\76"+
    "\13\6\5\0\2\6\15\0\5\6\1\77\10\6\5\0"+
    "\2\6\15\0\3\6\1\100\12\6\5\0\2\6\15\0"+
    "\3\6\1\101\12\6\5\0\2\6\15\0\5\6\1\102"+
    "\10\6\5\0\2\6\15\0\5\6\1\103\10\6\5\0"+
    "\2\6\15\0\7\6\1\104\6\6\5\0\2\6\15\0"+
    "\11\6\1\105\4\6\5\0\2\6\15\0\4\6\1\106"+
    "\11\6\5\0\2\6\15\0\6\6\1\107\7\6\5\0"+
    "\2\6\15\0\1\6\1\110\14\6\5\0\2\6\15\0"+
    "\14\6\1\111\1\6\5\0\2\6\15\0\7\6\1\112"+
    "\6\6\5\0\2\6\15\0\6\6\1\113\7\6\5\0"+
    "\2\6\15\0\7\6\1\114\6\6\5\0\2\6\15\0"+
    "\11\6\1\110\4\6\5\0\2\6\15\0\4\6\1\115"+
    "\11\6\5\0\2\6\15\0\2\6\1\116\13\6\5\0"+
    "\2\6\15\0\3\6\1\117\12\6\5\0\2\6\15\0"+
    "\4\6\1\120\11\6\5\0\2\6\15\0\7\6\1\121"+
    "\6\6\5\0\2\6\15\0\3\6\1\122\12\6\5\0"+
    "\2\6\15\0\4\6\1\123\11\6\1\0";

  private static int [] zzUnpackTrans() {
    int [] result = new int[1598];
    int offset = 0;
    offset = zzUnpackTrans(ZZ_TRANS_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackTrans(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      value--;
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }


  /* error codes */
  private static final int ZZ_UNKNOWN_ERROR = 0;
  private static final int ZZ_NO_MATCH = 1;
  private static final int ZZ_PUSHBACK_2BIG = 2;

  /* error messages for the codes above */
  private static final String ZZ_ERROR_MSG[] = {
    "Unkown internal scanner error",
    "Error: could not match input",
    "Error: pushback value was too large"
  };

  /**
   * ZZ_ATTRIBUTE[aState] contains the attributes of state <code>aState</code>
   */
  private static final int [] ZZ_ATTRIBUTE = zzUnpackAttribute();

  private static final String ZZ_ATTRIBUTE_PACKED_0 =
    "\3\0\1\1\1\11\2\1\1\0\4\11\1\1\3\11"+
    "\1\1\3\11\14\1\2\11\2\1\4\11\23\1\2\11"+
    "\26\1";

  private static int [] zzUnpackAttribute() {
    int [] result = new int[83];
    int offset = 0;
    offset = zzUnpackAttribute(ZZ_ATTRIBUTE_PACKED_0, offset, result);
    return result;
  }

  private static int zzUnpackAttribute(String packed, int offset, int [] result) {
    int i = 0;       /* index in packed string  */
    int j = offset;  /* index in unpacked array */
    int l = packed.length();
    while (i < l) {
      int count = packed.charAt(i++);
      int value = packed.charAt(i++);
      do result[j++] = value; while (--count > 0);
    }
    return j;
  }

  /** the input device */
  private java.io.Reader zzReader;

  /** the current state of the DFA */
  private int zzState;

  /** the current lexical state */
  private int zzLexicalState = YYINITIAL;

  /** this buffer contains the current text to be matched and is
      the source of the yytext() string */
  private char zzBuffer[] = new char[ZZ_BUFFERSIZE];

  /** the textposition at the last accepting state */
  private int zzMarkedPos;

  /** the current text position in the buffer */
  private int zzCurrentPos;

  /** startRead marks the beginning of the yytext() string in the buffer */
  private int zzStartRead;

  /** endRead marks the last character in the buffer, that has been read
      from input */
  private int zzEndRead;

  /** number of newlines encountered up to the start of the matched text */
  private int yyline;

  /** the number of characters up to the start of the matched text */
  private int yychar;

  /**
   * the number of characters from the last newline up to the start of the 
   * matched text
   */
  private int yycolumn;

  /** 
   * zzAtBOL == true <=> the scanner is currently at the beginning of a line
   */
  private boolean zzAtBOL = true;

  /** zzAtEOF == true <=> the scanner is at the EOF */
  private boolean zzAtEOF;

  /** denotes if the user-EOF-code has already been executed */
  private boolean zzEOFDone;

  /* user code: */
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


  /**
   * Creates a new scanner
   * There is also a java.io.InputStream version of this constructor.
   *
   * @param   in  the java.io.Reader to read input from.
   */
  public Lexer(java.io.Reader in) {
    this.zzReader = in;
  }

  /**
   * Creates a new scanner.
   * There is also java.io.Reader version of this constructor.
   *
   * @param   in  the java.io.Inputstream to read input from.
   */
  public Lexer(java.io.InputStream in) {
    this(new java.io.InputStreamReader(in));
  }

  /** 
   * Unpacks the compressed character translation table.
   *
   * @param packed   the packed character translation table
   * @return         the unpacked character translation table
   */
  private static char [] zzUnpackCMap(String packed) {
    char [] map = new char[0x10000];
    int i = 0;  /* index in packed string  */
    int j = 0;  /* index in unpacked array */
    while (i < 100) {
      int  count = packed.charAt(i++);
      char value = packed.charAt(i++);
      do map[j++] = value; while (--count > 0);
    }
    return map;
  }


  /**
   * Refills the input buffer.
   *
   * @return      <code>false</code>, iff there was new input.
   * 
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  private boolean zzRefill() throws java.io.IOException {

    /* first: make room (if you can) */
    if (zzStartRead > 0) {
      System.arraycopy(zzBuffer, zzStartRead,
                       zzBuffer, 0,
                       zzEndRead-zzStartRead);

      /* translate stored positions */
      zzEndRead-= zzStartRead;
      zzCurrentPos-= zzStartRead;
      zzMarkedPos-= zzStartRead;
      zzStartRead = 0;
    }

    /* is the buffer big enough? */
    if (zzCurrentPos >= zzBuffer.length) {
      /* if not: blow it up */
      char newBuffer[] = new char[zzCurrentPos*2];
      System.arraycopy(zzBuffer, 0, newBuffer, 0, zzBuffer.length);
      zzBuffer = newBuffer;
    }

    /* finally: fill the buffer with new input */
    int numRead = zzReader.read(zzBuffer, zzEndRead,
                                            zzBuffer.length-zzEndRead);

    if (numRead > 0) {
      zzEndRead+= numRead;
      return false;
    }
    // unlikely but not impossible: read 0 characters, but not at end of stream    
    if (numRead == 0) {
      int c = zzReader.read();
      if (c == -1) {
        return true;
      } else {
        zzBuffer[zzEndRead++] = (char) c;
        return false;
      }     
    }

	// numRead < 0
    return true;
  }

    
  /**
   * Closes the input stream.
   */
  public final void yyclose() throws java.io.IOException {
    zzAtEOF = true;            /* indicate end of file */
    zzEndRead = zzStartRead;  /* invalidate buffer    */

    if (zzReader != null)
      zzReader.close();
  }


  /**
   * Resets the scanner to read from a new input stream.
   * Does not close the old reader.
   *
   * All internal variables are reset, the old input stream 
   * <b>cannot</b> be reused (internal buffer is discarded and lost).
   * Lexical state is set to <tt>ZZ_INITIAL</tt>.
   *
   * @param reader   the new input stream 
   */
  public final void yyreset(java.io.Reader reader) {
    zzReader = reader;
    zzAtBOL  = true;
    zzAtEOF  = false;
    zzEOFDone = false;
    zzEndRead = zzStartRead = 0;
    zzCurrentPos = zzMarkedPos = 0;
    yyline = yychar = yycolumn = 0;
    zzLexicalState = YYINITIAL;
  }


  /**
   * Returns the current lexical state.
   */
  public final int yystate() {
    return zzLexicalState;
  }


  /**
   * Enters a new lexical state
   *
   * @param newState the new lexical state
   */
  public final void yybegin(int newState) {
    zzLexicalState = newState;
  }


  /**
   * Returns the text matched by the current regular expression.
   */
  public final String yytext() {
    return new String( zzBuffer, zzStartRead, zzMarkedPos-zzStartRead );
  }


  /**
   * Returns the character at position <tt>pos</tt> from the 
   * matched text. 
   * 
   * It is equivalent to yytext().charAt(pos), but faster
   *
   * @param pos the position of the character to fetch. 
   *            A value from 0 to yylength()-1.
   *
   * @return the character at position pos
   */
  public final char yycharat(int pos) {
    return zzBuffer[zzStartRead+pos];
  }


  /**
   * Returns the length of the matched text region.
   */
  public final int yylength() {
    return zzMarkedPos-zzStartRead;
  }


  /**
   * Reports an error that occured while scanning.
   *
   * In a wellformed scanner (no or only correct usage of 
   * yypushback(int) and a match-all fallback rule) this method 
   * will only be called with things that "Can't Possibly Happen".
   * If this method is called, something is seriously wrong
   * (e.g. a JFlex bug producing a faulty scanner etc.).
   *
   * Usual syntax/scanner level error handling should be done
   * in error fallback rules.
   *
   * @param   errorCode  the code of the errormessage to display
   */
  private void zzScanError(int errorCode) throws SyntaxError {
    String message;
    try {
      message = ZZ_ERROR_MSG[errorCode];
    }
    catch (ArrayIndexOutOfBoundsException e) {
      message = ZZ_ERROR_MSG[ZZ_UNKNOWN_ERROR];
    }

    throw new SyntaxError(message);
  } 


  /**
   * Pushes the specified amount of characters back into the input stream.
   *
   * They will be read again by then next call of the scanning method
   *
   * @param number  the number of characters to be read again.
   *                This number must not be greater than yylength()!
   */
  public void yypushback(int number)  throws SyntaxError {
    if ( number > yylength() )
      zzScanError(ZZ_PUSHBACK_2BIG);

    zzMarkedPos -= number;
  }


  /**
   * Contains user EOF-code, which will be executed exactly once,
   * when the end of file is reached
   */
  private void zzDoEOF() throws java.io.IOException {
    if (!zzEOFDone) {
      zzEOFDone = true;
      yyclose();
    }
  }


  /**
   * Resumes scanning until the next regular expression is matched,
   * the end of input is encountered or an I/O-Error occurs.
   *
   * @return      the next token
   * @exception   java.io.IOException  if any I/O-Error occurs
   */
  public java_cup.runtime.Symbol next_token() throws java.io.IOException, SyntaxError {
    int zzInput;
    int zzAction;

    // cached fields:
    int zzCurrentPosL;
    int zzMarkedPosL;
    int zzEndReadL = zzEndRead;
    char [] zzBufferL = zzBuffer;
    char [] zzCMapL = ZZ_CMAP;

    int [] zzTransL = ZZ_TRANS;
    int [] zzRowMapL = ZZ_ROWMAP;
    int [] zzAttrL = ZZ_ATTRIBUTE;

    while (true) {
      zzMarkedPosL = zzMarkedPos;

      boolean zzR = false;
      for (zzCurrentPosL = zzStartRead; zzCurrentPosL < zzMarkedPosL;
                                                             zzCurrentPosL++) {
        switch (zzBufferL[zzCurrentPosL]) {
        case '\u000B':
        case '\u000C':
        case '\u0085':
        case '\u2028':
        case '\u2029':
          yyline++;
          yycolumn = 0;
          zzR = false;
          break;
        case '\r':
          yyline++;
          yycolumn = 0;
          zzR = true;
          break;
        case '\n':
          if (zzR)
            zzR = false;
          else {
            yyline++;
            yycolumn = 0;
          }
          break;
        default:
          zzR = false;
          yycolumn++;
        }
      }

      if (zzR) {
        // peek one character ahead if it is \n (if we have counted one line too much)
        boolean zzPeek;
        if (zzMarkedPosL < zzEndReadL)
          zzPeek = zzBufferL[zzMarkedPosL] == '\n';
        else if (zzAtEOF)
          zzPeek = false;
        else {
          boolean eof = zzRefill();
          zzEndReadL = zzEndRead;
          zzMarkedPosL = zzMarkedPos;
          zzBufferL = zzBuffer;
          if (eof) 
            zzPeek = false;
          else 
            zzPeek = zzBufferL[zzMarkedPosL] == '\n';
        }
        if (zzPeek) yyline--;
      }
      zzAction = -1;

      zzCurrentPosL = zzCurrentPos = zzStartRead = zzMarkedPosL;
  
      zzState = ZZ_LEXSTATE[zzLexicalState];


      zzForAction: {
        while (true) {
    
          if (zzCurrentPosL < zzEndReadL)
            zzInput = zzBufferL[zzCurrentPosL++];
          else if (zzAtEOF) {
            zzInput = YYEOF;
            break zzForAction;
          }
          else {
            // store back cached positions
            zzCurrentPos  = zzCurrentPosL;
            zzMarkedPos   = zzMarkedPosL;
            boolean eof = zzRefill();
            // get translated positions and possibly new buffer
            zzCurrentPosL  = zzCurrentPos;
            zzMarkedPosL   = zzMarkedPos;
            zzBufferL      = zzBuffer;
            zzEndReadL     = zzEndRead;
            if (eof) {
              zzInput = YYEOF;
              break zzForAction;
            }
            else {
              zzInput = zzBufferL[zzCurrentPosL++];
            }
          }
          int zzNext = zzTransL[ zzRowMapL[zzState] + zzCMapL[zzInput] ];
          if (zzNext == -1) break zzForAction;
          zzState = zzNext;

          int zzAttributes = zzAttrL[zzState];
          if ( (zzAttributes & 1) == 1 ) {
            zzAction = zzState;
            zzMarkedPosL = zzCurrentPosL;
            if ( (zzAttributes & 8) == 8 ) break zzForAction;
          }

        }
      }

      // store back cached position
      zzMarkedPos = zzMarkedPosL;

      switch (zzAction < 0 ? zzAction : ZZ_ACTION[zzAction]) {
        case 19: 
          { report(yytext());return symbol(sym.ASSIGN);
          }
        case 42: break;
        case 24: 
          { report(yytext());return symbol(sym.DO);
          }
        case 43: break;
        case 34: 
          { report(yytext());return symbol(sym.SND);
          }
        case 44: break;
        case 27: 
          { comment_count++;report("/*");
          }
        case 45: break;
        case 8: 
          { report(yytext());return symbol(sym.MINUS);
          }
        case 46: break;
        case 16: 
          { yybegin(EOP);
          }
        case 47: break;
        case 22: 
          { report(yytext());return symbol(sym.IF);
          }
        case 48: break;
        case 2: 
          { report(yytext());return symbol(sym.ID, yytext());
          }
        case 49: break;
        case 14: 
          { report(yytext());return symbol(sym.UMINUS);
          }
        case 50: break;
        case 4: 
          { report(yytext());return symbol(sym.COMMA);
          }
        case 51: break;
        case 25: 
          { report(yytext());return symbol(sym.OR);
          }
        case 52: break;
        case 23: 
          { report(yytext());return symbol(sym.IN);
          }
        case 53: break;
        case 7: 
          { report(yytext());return symbol(sym.EQ);
          }
        case 54: break;
        case 18: 
          { report(yytext());return symbol(sym.CONS);
          }
        case 55: break;
        case 5: 
          { report(yytext());return symbol(sym.LPAREN);
          }
        case 56: break;
        case 28: 
          { report(yytext());return symbol(sym.FUN);
          }
        case 57: break;
        case 15: 
          { report(yytext());return symbol(sym.SEMICOLON);
          }
        case 58: break;
        case 32: 
          { report(yytext());return symbol(sym.LET);
          }
        case 59: break;
        case 26: 
          { comment_count--;report("*/");
					if (comment_count == 0){
						yybegin(YYINITIAL);
					}
          }
        case 60: break;
        case 30: 
          { report(yytext());return symbol(sym.NIL);
          }
        case 61: break;
        case 1: 
          { /*ignore*/
          }
        case 62: break;
        case 3: 
          { report(yytext());return symbol(sym.INT, new Integer(yytext()));
          }
        case 63: break;
        case 12: 
          { report(yytext());return symbol(sym.DIVIDE);
          }
        case 64: break;
        case 38: 
          { report(yytext());return symbol(sym.TAIL);
          }
        case 65: break;
        case 39: 
          { report(yytext());return symbol(sym.BOOLEAN, new Boolean(yytext()));
          }
        case 66: break;
        case 20: 
          { report(yytext());return symbol(sym.ARROW);
          }
        case 67: break;
        case 10: 
          { report(yytext());return symbol(sym.PLUS);
          }
        case 68: break;
        case 9: 
          { report(yytext());return symbol(sym.GT);
          }
        case 69: break;
        case 13: 
          { report(yytext());return symbol(sym.LT);
          }
        case 70: break;
        case 6: 
          { report(yytext());return symbol(sym.RPAREN);
          }
        case 71: break;
        case 36: 
          { report(yytext());return symbol(sym.ELSE);
          }
        case 72: break;
        case 11: 
          { report(yytext());return symbol(sym.TIMES);
          }
        case 73: break;
        case 29: 
          { report(yytext());return symbol(sym.FST);
          }
        case 74: break;
        case 37: 
          { report(yytext());return symbol(sym.THEN);
          }
        case 75: break;
        case 21: 
          { report("/*");yybegin(COMMENT);comment_count = 1;
          }
        case 76: break;
        case 41: 
          { report(yytext());return symbol(sym.WHILE);
          }
        case 77: break;
        case 33: 
          { report(yytext());return symbol(sym.END);
          }
        case 78: break;
        case 40: 
          { report(yytext());return symbol(sym.HEAD);
          }
        case 79: break;
        case 31: 
          { report(yytext());return symbol(sym.NOT);
          }
        case 80: break;
        case 35: 
          { report(yytext());return symbol(sym.AND);
          }
        case 81: break;
        case 17: 
          { 
          }
        case 82: break;
        default: 
          if (zzInput == YYEOF && zzStartRead == zzCurrentPos) {
            zzAtEOF = true;
            zzDoEOF();
              {
                if (yystate() == COMMENT){error("Comments are not closed!");}
		else if (yystate() != EOP){error("Program is incomplete!");}
		return symbol(sym.EOF);
              }
          } 
          else {
            zzScanError(ZZ_NO_MATCH);
          }
      }
    }
  }


}
