// Generated from D:/win/OneDrive/jg/iCode/Quartz/grammar\Quartz.g4 by ANTLR 4.6
package quartz.compiler.parser;

import org.antlr.v4.runtime.*;
import org.antlr.v4.runtime.atn.ATN;
import org.antlr.v4.runtime.atn.ATNDeserializer;
import org.antlr.v4.runtime.atn.LexerATNSimulator;
import org.antlr.v4.runtime.atn.PredictionContextCache;
import org.antlr.v4.runtime.dfa.DFA;

@SuppressWarnings({"all", "warnings", "unchecked", "unused", "cast"})
public class QuartzLexer extends Lexer {
	static { RuntimeMetaData.checkVersion("4.6", RuntimeMetaData.VERSION); }

	protected static final DFA[] _decisionToDFA;
	protected static final PredictionContextCache _sharedContextCache =
		new PredictionContextCache();
	public static final int
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, T__8=9, 
		DMOD=10, STRING=11, CHAR=12, INT=13, DOUBLE=14, INLINE_C=15, FN_MODIFIER=16, 
		VAR_DECLARATION_TYPE=17, RETURN=18, FN=19, EXTERN_FN=20, IF=21, ELSE=22, 
		WHILE=23, KEYWORD=24, IDENTIFIER=25, SYMBOL=26, BLOCK_COMMENT=27, LINE_COMMENT=28, 
		WHITESPACE=29;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
		"DMOD", "STRING", "CHAR", "INT", "DOUBLE", "INLINE_C", "FN_MODIFIER", 
		"VAR_DECLARATION_TYPE", "RETURN", "FN", "EXTERN_FN", "IF", "ELSE", "WHILE", 
		"KEYWORD", "IDENTIFIER", "SYMBOL", "BLOCK_COMMENT", "LINE_COMMENT", "WHITESPACE"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'('", "')'", "':'", "','", "'='", "'.'", "'[]'", "'{'", "'}'", 
		"'%%'", null, null, null, null, null, null, null, "'return'", "'fn'", 
		"'extern_fn'", "'if'", "'else'", "'while'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, "DMOD", "STRING", 
		"CHAR", "INT", "DOUBLE", "INLINE_C", "FN_MODIFIER", "VAR_DECLARATION_TYPE", 
		"RETURN", "FN", "EXTERN_FN", "IF", "ELSE", "WHILE", "KEYWORD", "IDENTIFIER", 
		"SYMBOL", "BLOCK_COMMENT", "LINE_COMMENT", "WHITESPACE"
	};
	public static final Vocabulary VOCABULARY = new VocabularyImpl(_LITERAL_NAMES, _SYMBOLIC_NAMES);

	/**
	 * @deprecated Use {@link #VOCABULARY} instead.
	 */
	@Deprecated
	public static final String[] tokenNames;
	static {
		tokenNames = new String[_SYMBOLIC_NAMES.length];
		for (int i = 0; i < tokenNames.length; i++) {
			tokenNames[i] = VOCABULARY.getLiteralName(i);
			if (tokenNames[i] == null) {
				tokenNames[i] = VOCABULARY.getSymbolicName(i);
			}

			if (tokenNames[i] == null) {
				tokenNames[i] = "<INVALID>";
			}
		}
	}

	@Override
	@Deprecated
	public String[] getTokenNames() {
		return tokenNames;
	}

	@Override

	public Vocabulary getVocabulary() {
		return VOCABULARY;
	}


	public QuartzLexer(CharStream input) {
		super(input);
		_interp = new LexerATNSimulator(this,_ATN,_decisionToDFA,_sharedContextCache);
	}

	@Override
	public String getGrammarFileName() { return "Quartz.g4"; }

	@Override
	public String[] getRuleNames() { return ruleNames; }

	@Override
	public String getSerializedATN() { return _serializedATN; }

	@Override
	public String[] getModeNames() { return modeNames; }

	@Override
	public ATN getATN() { return _ATN; }

	public static final String _serializedATN =
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\37\u00e7\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\3\2\3\2\3\3\3"+
		"\3\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3\b\3\t\3\t\3\n\3\n\3\13\3"+
		"\13\3\13\3\f\3\f\3\f\3\f\7\fX\n\f\f\f\16\f[\13\f\3\f\3\f\3\r\3\r\3\r\3"+
		"\r\3\16\6\16d\n\16\r\16\16\16e\3\17\7\17i\n\17\f\17\16\17l\13\17\3\17"+
		"\3\17\6\17p\n\17\r\17\16\17q\3\20\3\20\7\20v\n\20\f\20\16\20y\13\20\3"+
		"\20\3\20\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\3\21\5\21\u0086\n\21"+
		"\3\22\3\22\3\22\3\22\3\22\3\22\5\22\u008e\n\22\3\23\3\23\3\23\3\23\3\23"+
		"\3\23\3\23\3\24\3\24\3\24\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25\3\25"+
		"\3\25\3\26\3\26\3\26\3\27\3\27\3\27\3\27\3\27\3\30\3\30\3\30\3\30\3\30"+
		"\3\30\3\31\3\31\3\31\3\31\3\31\3\31\3\31\3\31\5\31\u00ba\n\31\3\32\3\32"+
		"\7\32\u00be\n\32\f\32\16\32\u00c1\13\32\3\33\6\33\u00c4\n\33\r\33\16\33"+
		"\u00c5\3\34\3\34\3\34\3\34\7\34\u00cc\n\34\f\34\16\34\u00cf\13\34\3\34"+
		"\3\34\3\34\3\34\3\34\3\35\3\35\3\35\3\35\7\35\u00da\n\35\f\35\16\35\u00dd"+
		"\13\35\3\35\3\35\3\36\6\36\u00e2\n\36\r\36\16\36\u00e3\3\36\3\36\5Yw\u00cd"+
		"\2\37\3\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35"+
		"\20\37\21!\22#\23%\24\'\25)\26+\27-\30/\31\61\32\63\33\65\34\67\359\36"+
		";\37\3\2\b\3\2\62;\5\2C\\aac|\6\2\62;C\\aac|\13\2##\'(,-//\61\61>@BB`"+
		"`~~\4\2\f\f\17\17\5\2\13\f\17\17\"\"\u00fa\2\3\3\2\2\2\2\5\3\2\2\2\2\7"+
		"\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2"+
		"\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2"+
		"\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2"+
		"\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2"+
		"\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2\2\2\2;\3\2\2\2\3=\3\2\2\2\5?\3\2\2\2"+
		"\7A\3\2\2\2\tC\3\2\2\2\13E\3\2\2\2\rG\3\2\2\2\17I\3\2\2\2\21L\3\2\2\2"+
		"\23N\3\2\2\2\25P\3\2\2\2\27S\3\2\2\2\31^\3\2\2\2\33c\3\2\2\2\35j\3\2\2"+
		"\2\37s\3\2\2\2!\u0085\3\2\2\2#\u008d\3\2\2\2%\u008f\3\2\2\2\'\u0096\3"+
		"\2\2\2)\u0099\3\2\2\2+\u00a3\3\2\2\2-\u00a6\3\2\2\2/\u00ab\3\2\2\2\61"+
		"\u00b9\3\2\2\2\63\u00bb\3\2\2\2\65\u00c3\3\2\2\2\67\u00c7\3\2\2\29\u00d5"+
		"\3\2\2\2;\u00e1\3\2\2\2=>\7*\2\2>\4\3\2\2\2?@\7+\2\2@\6\3\2\2\2AB\7<\2"+
		"\2B\b\3\2\2\2CD\7.\2\2D\n\3\2\2\2EF\7?\2\2F\f\3\2\2\2GH\7\60\2\2H\16\3"+
		"\2\2\2IJ\7]\2\2JK\7_\2\2K\20\3\2\2\2LM\7}\2\2M\22\3\2\2\2NO\7\177\2\2"+
		"O\24\3\2\2\2PQ\7\'\2\2QR\7\'\2\2R\26\3\2\2\2SY\7$\2\2TU\7^\2\2UX\13\2"+
		"\2\2VX\13\2\2\2WT\3\2\2\2WV\3\2\2\2X[\3\2\2\2YZ\3\2\2\2YW\3\2\2\2Z\\\3"+
		"\2\2\2[Y\3\2\2\2\\]\7$\2\2]\30\3\2\2\2^_\7)\2\2_`\13\2\2\2`a\7)\2\2a\32"+
		"\3\2\2\2bd\t\2\2\2cb\3\2\2\2de\3\2\2\2ec\3\2\2\2ef\3\2\2\2f\34\3\2\2\2"+
		"gi\t\2\2\2hg\3\2\2\2il\3\2\2\2jh\3\2\2\2jk\3\2\2\2km\3\2\2\2lj\3\2\2\2"+
		"mo\7\60\2\2np\t\2\2\2on\3\2\2\2pq\3\2\2\2qo\3\2\2\2qr\3\2\2\2r\36\3\2"+
		"\2\2sw\5\25\13\2tv\13\2\2\2ut\3\2\2\2vy\3\2\2\2wx\3\2\2\2wu\3\2\2\2xz"+
		"\3\2\2\2yw\3\2\2\2z{\5\25\13\2{ \3\2\2\2|}\7i\2\2}~\7r\2\2~\u0086\7w\2"+
		"\2\177\u0080\7k\2\2\u0080\u0081\7p\2\2\u0081\u0082\7n\2\2\u0082\u0083"+
		"\7k\2\2\u0083\u0084\7p\2\2\u0084\u0086\7g\2\2\u0085|\3\2\2\2\u0085\177"+
		"\3\2\2\2\u0086\"\3\2\2\2\u0087\u0088\7x\2\2\u0088\u0089\7c\2\2\u0089\u008e"+
		"\7n\2\2\u008a\u008b\7x\2\2\u008b\u008c\7c\2\2\u008c\u008e\7t\2\2\u008d"+
		"\u0087\3\2\2\2\u008d\u008a\3\2\2\2\u008e$\3\2\2\2\u008f\u0090\7t\2\2\u0090"+
		"\u0091\7g\2\2\u0091\u0092\7v\2\2\u0092\u0093\7w\2\2\u0093\u0094\7t\2\2"+
		"\u0094\u0095\7p\2\2\u0095&\3\2\2\2\u0096\u0097\7h\2\2\u0097\u0098\7p\2"+
		"\2\u0098(\3\2\2\2\u0099\u009a\7g\2\2\u009a\u009b\7z\2\2\u009b\u009c\7"+
		"v\2\2\u009c\u009d\7g\2\2\u009d\u009e\7t\2\2\u009e\u009f\7p\2\2\u009f\u00a0"+
		"\7a\2\2\u00a0\u00a1\7h\2\2\u00a1\u00a2\7p\2\2\u00a2*\3\2\2\2\u00a3\u00a4"+
		"\7k\2\2\u00a4\u00a5\7h\2\2\u00a5,\3\2\2\2\u00a6\u00a7\7g\2\2\u00a7\u00a8"+
		"\7n\2\2\u00a8\u00a9\7u\2\2\u00a9\u00aa\7g\2\2\u00aa.\3\2\2\2\u00ab\u00ac"+
		"\7y\2\2\u00ac\u00ad\7j\2\2\u00ad\u00ae\7k\2\2\u00ae\u00af\7n\2\2\u00af"+
		"\u00b0\7g\2\2\u00b0\60\3\2\2\2\u00b1\u00ba\5!\21\2\u00b2\u00ba\5#\22\2"+
		"\u00b3\u00ba\5%\23\2\u00b4\u00ba\5\'\24\2\u00b5\u00ba\5)\25\2\u00b6\u00ba"+
		"\5+\26\2\u00b7\u00ba\5-\27\2\u00b8\u00ba\5/\30\2\u00b9\u00b1\3\2\2\2\u00b9"+
		"\u00b2\3\2\2\2\u00b9\u00b3\3\2\2\2\u00b9\u00b4\3\2\2\2\u00b9\u00b5\3\2"+
		"\2\2\u00b9\u00b6\3\2\2\2\u00b9\u00b7\3\2\2\2\u00b9\u00b8\3\2\2\2\u00ba"+
		"\62\3\2\2\2\u00bb\u00bf\t\3\2\2\u00bc\u00be\t\4\2\2\u00bd\u00bc\3\2\2"+
		"\2\u00be\u00c1\3\2\2\2\u00bf\u00bd\3\2\2\2\u00bf\u00c0\3\2\2\2\u00c0\64"+
		"\3\2\2\2\u00c1\u00bf\3\2\2\2\u00c2\u00c4\t\5\2\2\u00c3\u00c2\3\2\2\2\u00c4"+
		"\u00c5\3\2\2\2\u00c5\u00c3\3\2\2\2\u00c5\u00c6\3\2\2\2\u00c6\66\3\2\2"+
		"\2\u00c7\u00c8\7\61\2\2\u00c8\u00c9\7,\2\2\u00c9\u00cd\3\2\2\2\u00ca\u00cc"+
		"\13\2\2\2\u00cb\u00ca\3\2\2\2\u00cc\u00cf\3\2\2\2\u00cd\u00ce\3\2\2\2"+
		"\u00cd\u00cb\3\2\2\2\u00ce\u00d0\3\2\2\2\u00cf\u00cd\3\2\2\2\u00d0\u00d1"+
		"\7,\2\2\u00d1\u00d2\7\61\2\2\u00d2\u00d3\3\2\2\2\u00d3\u00d4\b\34\2\2"+
		"\u00d48\3\2\2\2\u00d5\u00d6\7\61\2\2\u00d6\u00d7\7\61\2\2\u00d7\u00db"+
		"\3\2\2\2\u00d8\u00da\n\6\2\2\u00d9\u00d8\3\2\2\2\u00da\u00dd\3\2\2\2\u00db"+
		"\u00d9\3\2\2\2\u00db\u00dc\3\2\2\2\u00dc\u00de\3\2\2\2\u00dd\u00db\3\2"+
		"\2\2\u00de\u00df\b\35\2\2\u00df:\3\2\2\2\u00e0\u00e2\t\7\2\2\u00e1\u00e0"+
		"\3\2\2\2\u00e2\u00e3\3\2\2\2\u00e3\u00e1\3\2\2\2\u00e3\u00e4\3\2\2\2\u00e4"+
		"\u00e5\3\2\2\2\u00e5\u00e6\b\36\2\2\u00e6<\3\2\2\2\21\2WYejqw\u0085\u008d"+
		"\u00b9\u00bf\u00c5\u00cd\u00db\u00e3\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}