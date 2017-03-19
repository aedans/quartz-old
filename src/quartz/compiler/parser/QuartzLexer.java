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
		T__0=1, T__1=2, T__2=3, T__3=4, T__4=5, T__5=6, T__6=7, T__7=8, DMOD=9, 
		STRING=10, CHAR=11, INT=12, DOUBLE=13, INLINE_C=14, FN_MODIFIER=15, VAR_DECLARATION_TYPE=16, 
		RETURN=17, FN=18, EXTERN_FN=19, IF=20, ELSE=21, WHILE=22, KEYWORD=23, 
		IDENTIFIER=24, SYMBOL=25, BLOCK_COMMENT=26, LINE_COMMENT=27, WHITESPACE=28;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "DMOD", 
		"STRING", "CHAR", "INT", "DOUBLE", "INLINE_C", "FN_MODIFIER", "VAR_DECLARATION_TYPE", 
		"RETURN", "FN", "EXTERN_FN", "IF", "ELSE", "WHILE", "KEYWORD", "IDENTIFIER", 
		"SYMBOL", "BLOCK_COMMENT", "LINE_COMMENT", "WHITESPACE"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'('", "')'", "':'", "','", "'='", "'[]'", "'{'", "'}'", "'%%'", 
		null, null, null, null, null, null, null, "'return'", "'fn'", "'extern_fn'", 
		"'if'", "'else'", "'while'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, "DMOD", "STRING", 
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2\36\u00e3\b\1\4\2"+
		"\t\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4"+
		"\13\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22"+
		"\t\22\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31"+
		"\t\31\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\3\2\3\2\3\3\3\3\3\4\3\4"+
		"\3\5\3\5\3\6\3\6\3\7\3\7\3\7\3\b\3\b\3\t\3\t\3\n\3\n\3\n\3\13\3\13\3\13"+
		"\3\13\7\13T\n\13\f\13\16\13W\13\13\3\13\3\13\3\f\3\f\3\f\3\f\3\r\6\r`"+
		"\n\r\r\r\16\ra\3\16\7\16e\n\16\f\16\16\16h\13\16\3\16\3\16\6\16l\n\16"+
		"\r\16\16\16m\3\17\3\17\7\17r\n\17\f\17\16\17u\13\17\3\17\3\17\3\20\3\20"+
		"\3\20\3\20\3\20\3\20\3\20\3\20\3\20\5\20\u0082\n\20\3\21\3\21\3\21\3\21"+
		"\3\21\3\21\5\21\u008a\n\21\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\23\3\23"+
		"\3\23\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\24\3\25\3\25\3\25"+
		"\3\26\3\26\3\26\3\26\3\26\3\27\3\27\3\27\3\27\3\27\3\27\3\30\3\30\3\30"+
		"\3\30\3\30\3\30\3\30\3\30\5\30\u00b6\n\30\3\31\3\31\7\31\u00ba\n\31\f"+
		"\31\16\31\u00bd\13\31\3\32\6\32\u00c0\n\32\r\32\16\32\u00c1\3\33\3\33"+
		"\3\33\3\33\7\33\u00c8\n\33\f\33\16\33\u00cb\13\33\3\33\3\33\3\33\3\33"+
		"\3\33\3\34\3\34\3\34\3\34\7\34\u00d6\n\34\f\34\16\34\u00d9\13\34\3\34"+
		"\3\34\3\35\6\35\u00de\n\35\r\35\16\35\u00df\3\35\3\35\5Us\u00c9\2\36\3"+
		"\3\5\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37"+
		"\21!\22#\23%\24\'\25)\26+\27-\30/\31\61\32\63\33\65\34\67\359\36\3\2\b"+
		"\3\2\62;\5\2C\\aac|\6\2\62;C\\aac|\t\2##\'(,\61>@BB``~~\4\2\f\f\17\17"+
		"\5\2\13\f\17\17\"\"\u00f6\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2"+
		"\2\2\2\13\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2"+
		"\25\3\2\2\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3"+
		"\2\2\2\2!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2"+
		"\2\2\2-\3\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67"+
		"\3\2\2\2\29\3\2\2\2\3;\3\2\2\2\5=\3\2\2\2\7?\3\2\2\2\tA\3\2\2\2\13C\3"+
		"\2\2\2\rE\3\2\2\2\17H\3\2\2\2\21J\3\2\2\2\23L\3\2\2\2\25O\3\2\2\2\27Z"+
		"\3\2\2\2\31_\3\2\2\2\33f\3\2\2\2\35o\3\2\2\2\37\u0081\3\2\2\2!\u0089\3"+
		"\2\2\2#\u008b\3\2\2\2%\u0092\3\2\2\2\'\u0095\3\2\2\2)\u009f\3\2\2\2+\u00a2"+
		"\3\2\2\2-\u00a7\3\2\2\2/\u00b5\3\2\2\2\61\u00b7\3\2\2\2\63\u00bf\3\2\2"+
		"\2\65\u00c3\3\2\2\2\67\u00d1\3\2\2\29\u00dd\3\2\2\2;<\7*\2\2<\4\3\2\2"+
		"\2=>\7+\2\2>\6\3\2\2\2?@\7<\2\2@\b\3\2\2\2AB\7.\2\2B\n\3\2\2\2CD\7?\2"+
		"\2D\f\3\2\2\2EF\7]\2\2FG\7_\2\2G\16\3\2\2\2HI\7}\2\2I\20\3\2\2\2JK\7\177"+
		"\2\2K\22\3\2\2\2LM\7\'\2\2MN\7\'\2\2N\24\3\2\2\2OU\7$\2\2PQ\7^\2\2QT\13"+
		"\2\2\2RT\13\2\2\2SP\3\2\2\2SR\3\2\2\2TW\3\2\2\2UV\3\2\2\2US\3\2\2\2VX"+
		"\3\2\2\2WU\3\2\2\2XY\7$\2\2Y\26\3\2\2\2Z[\7)\2\2[\\\13\2\2\2\\]\7)\2\2"+
		"]\30\3\2\2\2^`\t\2\2\2_^\3\2\2\2`a\3\2\2\2a_\3\2\2\2ab\3\2\2\2b\32\3\2"+
		"\2\2ce\t\2\2\2dc\3\2\2\2eh\3\2\2\2fd\3\2\2\2fg\3\2\2\2gi\3\2\2\2hf\3\2"+
		"\2\2ik\7\60\2\2jl\t\2\2\2kj\3\2\2\2lm\3\2\2\2mk\3\2\2\2mn\3\2\2\2n\34"+
		"\3\2\2\2os\5\23\n\2pr\13\2\2\2qp\3\2\2\2ru\3\2\2\2st\3\2\2\2sq\3\2\2\2"+
		"tv\3\2\2\2us\3\2\2\2vw\5\23\n\2w\36\3\2\2\2xy\7i\2\2yz\7r\2\2z\u0082\7"+
		"w\2\2{|\7k\2\2|}\7p\2\2}~\7n\2\2~\177\7k\2\2\177\u0080\7p\2\2\u0080\u0082"+
		"\7g\2\2\u0081x\3\2\2\2\u0081{\3\2\2\2\u0082 \3\2\2\2\u0083\u0084\7x\2"+
		"\2\u0084\u0085\7c\2\2\u0085\u008a\7n\2\2\u0086\u0087\7x\2\2\u0087\u0088"+
		"\7c\2\2\u0088\u008a\7t\2\2\u0089\u0083\3\2\2\2\u0089\u0086\3\2\2\2\u008a"+
		"\"\3\2\2\2\u008b\u008c\7t\2\2\u008c\u008d\7g\2\2\u008d\u008e\7v\2\2\u008e"+
		"\u008f\7w\2\2\u008f\u0090\7t\2\2\u0090\u0091\7p\2\2\u0091$\3\2\2\2\u0092"+
		"\u0093\7h\2\2\u0093\u0094\7p\2\2\u0094&\3\2\2\2\u0095\u0096\7g\2\2\u0096"+
		"\u0097\7z\2\2\u0097\u0098\7v\2\2\u0098\u0099\7g\2\2\u0099\u009a\7t\2\2"+
		"\u009a\u009b\7p\2\2\u009b\u009c\7a\2\2\u009c\u009d\7h\2\2\u009d\u009e"+
		"\7p\2\2\u009e(\3\2\2\2\u009f\u00a0\7k\2\2\u00a0\u00a1\7h\2\2\u00a1*\3"+
		"\2\2\2\u00a2\u00a3\7g\2\2\u00a3\u00a4\7n\2\2\u00a4\u00a5\7u\2\2\u00a5"+
		"\u00a6\7g\2\2\u00a6,\3\2\2\2\u00a7\u00a8\7y\2\2\u00a8\u00a9\7j\2\2\u00a9"+
		"\u00aa\7k\2\2\u00aa\u00ab\7n\2\2\u00ab\u00ac\7g\2\2\u00ac.\3\2\2\2\u00ad"+
		"\u00b6\5\37\20\2\u00ae\u00b6\5!\21\2\u00af\u00b6\5#\22\2\u00b0\u00b6\5"+
		"%\23\2\u00b1\u00b6\5\'\24\2\u00b2\u00b6\5)\25\2\u00b3\u00b6\5+\26\2\u00b4"+
		"\u00b6\5-\27\2\u00b5\u00ad\3\2\2\2\u00b5\u00ae\3\2\2\2\u00b5\u00af\3\2"+
		"\2\2\u00b5\u00b0\3\2\2\2\u00b5\u00b1\3\2\2\2\u00b5\u00b2\3\2\2\2\u00b5"+
		"\u00b3\3\2\2\2\u00b5\u00b4\3\2\2\2\u00b6\60\3\2\2\2\u00b7\u00bb\t\3\2"+
		"\2\u00b8\u00ba\t\4\2\2\u00b9\u00b8\3\2\2\2\u00ba\u00bd\3\2\2\2\u00bb\u00b9"+
		"\3\2\2\2\u00bb\u00bc\3\2\2\2\u00bc\62\3\2\2\2\u00bd\u00bb\3\2\2\2\u00be"+
		"\u00c0\t\5\2\2\u00bf\u00be\3\2\2\2\u00c0\u00c1\3\2\2\2\u00c1\u00bf\3\2"+
		"\2\2\u00c1\u00c2\3\2\2\2\u00c2\64\3\2\2\2\u00c3\u00c4\7\61\2\2\u00c4\u00c5"+
		"\7,\2\2\u00c5\u00c9\3\2\2\2\u00c6\u00c8\13\2\2\2\u00c7\u00c6\3\2\2\2\u00c8"+
		"\u00cb\3\2\2\2\u00c9\u00ca\3\2\2\2\u00c9\u00c7\3\2\2\2\u00ca\u00cc\3\2"+
		"\2\2\u00cb\u00c9\3\2\2\2\u00cc\u00cd\7,\2\2\u00cd\u00ce\7\61\2\2\u00ce"+
		"\u00cf\3\2\2\2\u00cf\u00d0\b\33\2\2\u00d0\66\3\2\2\2\u00d1\u00d2\7\61"+
		"\2\2\u00d2\u00d3\7\61\2\2\u00d3\u00d7\3\2\2\2\u00d4\u00d6\n\6\2\2\u00d5"+
		"\u00d4\3\2\2\2\u00d6\u00d9\3\2\2\2\u00d7\u00d5\3\2\2\2\u00d7\u00d8\3\2"+
		"\2\2\u00d8\u00da\3\2\2\2\u00d9\u00d7\3\2\2\2\u00da\u00db\b\34\2\2\u00db"+
		"8\3\2\2\2\u00dc\u00de\t\7\2\2\u00dd\u00dc\3\2\2\2\u00de\u00df\3\2\2\2"+
		"\u00df\u00dd\3\2\2\2\u00df\u00e0\3\2\2\2\u00e0\u00e1\3\2\2\2\u00e1\u00e2"+
		"\b\35\2\2\u00e2:\3\2\2\2\21\2SUafms\u0081\u0089\u00b5\u00bb\u00c1\u00c9"+
		"\u00d7\u00df\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}