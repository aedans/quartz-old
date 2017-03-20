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
		T__9=10, T__10=11, T__11=12, T__12=13, T__13=14, T__14=15, T__15=16, T__16=17, 
		T__17=18, T__18=19, T__19=20, T__20=21, T__21=22, T__22=23, T__23=24, 
		T__24=25, DMOD=26, STRING=27, CHAR=28, INT=29, DOUBLE=30, INLINE_C=31, 
		FN_MODIFIER=32, VAR_DECLARATION_TYPE=33, RETURN=34, FN=35, EXTERN_FN=36, 
		IF=37, ELSE=38, WHILE=39, KEYWORD=40, IDENTIFIER=41, BLOCK_COMMENT=42, 
		LINE_COMMENT=43, WHITESPACE=44;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
		"T__9", "T__10", "T__11", "T__12", "T__13", "T__14", "T__15", "T__16", 
		"T__17", "T__18", "T__19", "T__20", "T__21", "T__22", "T__23", "T__24", 
		"DMOD", "STRING", "CHAR", "INT", "DOUBLE", "INLINE_C", "FN_MODIFIER", 
		"VAR_DECLARATION_TYPE", "RETURN", "FN", "EXTERN_FN", "IF", "ELSE", "WHILE", 
		"KEYWORD", "IDENTIFIER", "BLOCK_COMMENT", "LINE_COMMENT", "WHITESPACE"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'('", "')'", "':'", "','", "'='", "'||'", "'&&'", "'=='", "'!='", 
		"'>'", "'<'", "'>='", "'<='", "'+'", "'-'", "'*'", "'/'", "'%'", "'!'", 
		"'['", "']'", "'.'", "'[]'", "'{'", "'}'", "'%%'", null, null, null, null, 
		null, null, null, "'return'", "'fn'", "'extern_fn'", "'if'", "'else'", 
		"'while'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, "DMOD", "STRING", "CHAR", "INT", "DOUBLE", "INLINE_C", "FN_MODIFIER", 
		"VAR_DECLARATION_TYPE", "RETURN", "FN", "EXTERN_FN", "IF", "ELSE", "WHILE", 
		"KEYWORD", "IDENTIFIER", "BLOCK_COMMENT", "LINE_COMMENT", "WHITESPACE"
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2.\u0126\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\3\2\3\2\3\3\3\3\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\7\3\b\3\b"+
		"\3\b\3\t\3\t\3\t\3\n\3\n\3\n\3\13\3\13\3\f\3\f\3\r\3\r\3\r\3\16\3\16\3"+
		"\16\3\17\3\17\3\20\3\20\3\21\3\21\3\22\3\22\3\23\3\23\3\24\3\24\3\25\3"+
		"\25\3\26\3\26\3\27\3\27\3\30\3\30\3\30\3\31\3\31\3\32\3\32\3\33\3\33\3"+
		"\33\3\34\3\34\3\34\3\34\7\34\u009c\n\34\f\34\16\34\u009f\13\34\3\34\3"+
		"\34\3\35\3\35\3\35\3\35\3\36\6\36\u00a8\n\36\r\36\16\36\u00a9\3\37\7\37"+
		"\u00ad\n\37\f\37\16\37\u00b0\13\37\3\37\3\37\6\37\u00b4\n\37\r\37\16\37"+
		"\u00b5\3 \3 \7 \u00ba\n \f \16 \u00bd\13 \3 \3 \3!\3!\3!\3!\3!\3!\3!\3"+
		"!\3!\5!\u00ca\n!\3\"\3\"\3\"\3\"\3\"\3\"\5\"\u00d2\n\"\3#\3#\3#\3#\3#"+
		"\3#\3#\3$\3$\3$\3%\3%\3%\3%\3%\3%\3%\3%\3%\3%\3&\3&\3&\3\'\3\'\3\'\3\'"+
		"\3\'\3(\3(\3(\3(\3(\3(\3)\3)\3)\3)\3)\3)\3)\3)\5)\u00fe\n)\3*\3*\7*\u0102"+
		"\n*\f*\16*\u0105\13*\3+\3+\3+\3+\7+\u010b\n+\f+\16+\u010e\13+\3+\3+\3"+
		"+\3+\3+\3,\3,\3,\3,\7,\u0119\n,\f,\16,\u011c\13,\3,\3,\3-\6-\u0121\n-"+
		"\r-\16-\u0122\3-\3-\5\u009d\u00bb\u010c\2.\3\3\5\4\7\5\t\6\13\7\r\b\17"+
		"\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21!\22#\23%\24\'\25)\26+"+
		"\27-\30/\31\61\32\63\33\65\34\67\359\36;\37= ?!A\"C#E$G%I&K\'M(O)Q*S+"+
		"U,W-Y.\3\2\7\3\2\62;\5\2C\\aac|\6\2\62;C\\aac|\4\2\f\f\17\17\5\2\13\f"+
		"\17\17\"\"\u0138\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13"+
		"\3\2\2\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2"+
		"\2\2\27\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2"+
		"!\3\2\2\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3"+
		"\2\2\2\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2"+
		"\29\3\2\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E"+
		"\3\2\2\2\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2O\3\2\2\2\2Q\3\2"+
		"\2\2\2S\3\2\2\2\2U\3\2\2\2\2W\3\2\2\2\2Y\3\2\2\2\3[\3\2\2\2\5]\3\2\2\2"+
		"\7_\3\2\2\2\ta\3\2\2\2\13c\3\2\2\2\re\3\2\2\2\17h\3\2\2\2\21k\3\2\2\2"+
		"\23n\3\2\2\2\25q\3\2\2\2\27s\3\2\2\2\31u\3\2\2\2\33x\3\2\2\2\35{\3\2\2"+
		"\2\37}\3\2\2\2!\177\3\2\2\2#\u0081\3\2\2\2%\u0083\3\2\2\2\'\u0085\3\2"+
		"\2\2)\u0087\3\2\2\2+\u0089\3\2\2\2-\u008b\3\2\2\2/\u008d\3\2\2\2\61\u0090"+
		"\3\2\2\2\63\u0092\3\2\2\2\65\u0094\3\2\2\2\67\u0097\3\2\2\29\u00a2\3\2"+
		"\2\2;\u00a7\3\2\2\2=\u00ae\3\2\2\2?\u00b7\3\2\2\2A\u00c9\3\2\2\2C\u00d1"+
		"\3\2\2\2E\u00d3\3\2\2\2G\u00da\3\2\2\2I\u00dd\3\2\2\2K\u00e7\3\2\2\2M"+
		"\u00ea\3\2\2\2O\u00ef\3\2\2\2Q\u00fd\3\2\2\2S\u00ff\3\2\2\2U\u0106\3\2"+
		"\2\2W\u0114\3\2\2\2Y\u0120\3\2\2\2[\\\7*\2\2\\\4\3\2\2\2]^\7+\2\2^\6\3"+
		"\2\2\2_`\7<\2\2`\b\3\2\2\2ab\7.\2\2b\n\3\2\2\2cd\7?\2\2d\f\3\2\2\2ef\7"+
		"~\2\2fg\7~\2\2g\16\3\2\2\2hi\7(\2\2ij\7(\2\2j\20\3\2\2\2kl\7?\2\2lm\7"+
		"?\2\2m\22\3\2\2\2no\7#\2\2op\7?\2\2p\24\3\2\2\2qr\7@\2\2r\26\3\2\2\2s"+
		"t\7>\2\2t\30\3\2\2\2uv\7@\2\2vw\7?\2\2w\32\3\2\2\2xy\7>\2\2yz\7?\2\2z"+
		"\34\3\2\2\2{|\7-\2\2|\36\3\2\2\2}~\7/\2\2~ \3\2\2\2\177\u0080\7,\2\2\u0080"+
		"\"\3\2\2\2\u0081\u0082\7\61\2\2\u0082$\3\2\2\2\u0083\u0084\7\'\2\2\u0084"+
		"&\3\2\2\2\u0085\u0086\7#\2\2\u0086(\3\2\2\2\u0087\u0088\7]\2\2\u0088*"+
		"\3\2\2\2\u0089\u008a\7_\2\2\u008a,\3\2\2\2\u008b\u008c\7\60\2\2\u008c"+
		".\3\2\2\2\u008d\u008e\7]\2\2\u008e\u008f\7_\2\2\u008f\60\3\2\2\2\u0090"+
		"\u0091\7}\2\2\u0091\62\3\2\2\2\u0092\u0093\7\177\2\2\u0093\64\3\2\2\2"+
		"\u0094\u0095\7\'\2\2\u0095\u0096\7\'\2\2\u0096\66\3\2\2\2\u0097\u009d"+
		"\7$\2\2\u0098\u0099\7^\2\2\u0099\u009c\13\2\2\2\u009a\u009c\13\2\2\2\u009b"+
		"\u0098\3\2\2\2\u009b\u009a\3\2\2\2\u009c\u009f\3\2\2\2\u009d\u009e\3\2"+
		"\2\2\u009d\u009b\3\2\2\2\u009e\u00a0\3\2\2\2\u009f\u009d\3\2\2\2\u00a0"+
		"\u00a1\7$\2\2\u00a18\3\2\2\2\u00a2\u00a3\7)\2\2\u00a3\u00a4\13\2\2\2\u00a4"+
		"\u00a5\7)\2\2\u00a5:\3\2\2\2\u00a6\u00a8\t\2\2\2\u00a7\u00a6\3\2\2\2\u00a8"+
		"\u00a9\3\2\2\2\u00a9\u00a7\3\2\2\2\u00a9\u00aa\3\2\2\2\u00aa<\3\2\2\2"+
		"\u00ab\u00ad\t\2\2\2\u00ac\u00ab\3\2\2\2\u00ad\u00b0\3\2\2\2\u00ae\u00ac"+
		"\3\2\2\2\u00ae\u00af\3\2\2\2\u00af\u00b1\3\2\2\2\u00b0\u00ae\3\2\2\2\u00b1"+
		"\u00b3\7\60\2\2\u00b2\u00b4\t\2\2\2\u00b3\u00b2\3\2\2\2\u00b4\u00b5\3"+
		"\2\2\2\u00b5\u00b3\3\2\2\2\u00b5\u00b6\3\2\2\2\u00b6>\3\2\2\2\u00b7\u00bb"+
		"\5\65\33\2\u00b8\u00ba\13\2\2\2\u00b9\u00b8\3\2\2\2\u00ba\u00bd\3\2\2"+
		"\2\u00bb\u00bc\3\2\2\2\u00bb\u00b9\3\2\2\2\u00bc\u00be\3\2\2\2\u00bd\u00bb"+
		"\3\2\2\2\u00be\u00bf\5\65\33\2\u00bf@\3\2\2\2\u00c0\u00c1\7i\2\2\u00c1"+
		"\u00c2\7r\2\2\u00c2\u00ca\7w\2\2\u00c3\u00c4\7k\2\2\u00c4\u00c5\7p\2\2"+
		"\u00c5\u00c6\7n\2\2\u00c6\u00c7\7k\2\2\u00c7\u00c8\7p\2\2\u00c8\u00ca"+
		"\7g\2\2\u00c9\u00c0\3\2\2\2\u00c9\u00c3\3\2\2\2\u00caB\3\2\2\2\u00cb\u00cc"+
		"\7x\2\2\u00cc\u00cd\7c\2\2\u00cd\u00d2\7n\2\2\u00ce\u00cf\7x\2\2\u00cf"+
		"\u00d0\7c\2\2\u00d0\u00d2\7t\2\2\u00d1\u00cb\3\2\2\2\u00d1\u00ce\3\2\2"+
		"\2\u00d2D\3\2\2\2\u00d3\u00d4\7t\2\2\u00d4\u00d5\7g\2\2\u00d5\u00d6\7"+
		"v\2\2\u00d6\u00d7\7w\2\2\u00d7\u00d8\7t\2\2\u00d8\u00d9\7p\2\2\u00d9F"+
		"\3\2\2\2\u00da\u00db\7h\2\2\u00db\u00dc\7p\2\2\u00dcH\3\2\2\2\u00dd\u00de"+
		"\7g\2\2\u00de\u00df\7z\2\2\u00df\u00e0\7v\2\2\u00e0\u00e1\7g\2\2\u00e1"+
		"\u00e2\7t\2\2\u00e2\u00e3\7p\2\2\u00e3\u00e4\7a\2\2\u00e4\u00e5\7h\2\2"+
		"\u00e5\u00e6\7p\2\2\u00e6J\3\2\2\2\u00e7\u00e8\7k\2\2\u00e8\u00e9\7h\2"+
		"\2\u00e9L\3\2\2\2\u00ea\u00eb\7g\2\2\u00eb\u00ec\7n\2\2\u00ec\u00ed\7"+
		"u\2\2\u00ed\u00ee\7g\2\2\u00eeN\3\2\2\2\u00ef\u00f0\7y\2\2\u00f0\u00f1"+
		"\7j\2\2\u00f1\u00f2\7k\2\2\u00f2\u00f3\7n\2\2\u00f3\u00f4\7g\2\2\u00f4"+
		"P\3\2\2\2\u00f5\u00fe\5A!\2\u00f6\u00fe\5C\"\2\u00f7\u00fe\5E#\2\u00f8"+
		"\u00fe\5G$\2\u00f9\u00fe\5I%\2\u00fa\u00fe\5K&\2\u00fb\u00fe\5M\'\2\u00fc"+
		"\u00fe\5O(\2\u00fd\u00f5\3\2\2\2\u00fd\u00f6\3\2\2\2\u00fd\u00f7\3\2\2"+
		"\2\u00fd\u00f8\3\2\2\2\u00fd\u00f9\3\2\2\2\u00fd\u00fa\3\2\2\2\u00fd\u00fb"+
		"\3\2\2\2\u00fd\u00fc\3\2\2\2\u00feR\3\2\2\2\u00ff\u0103\t\3\2\2\u0100"+
		"\u0102\t\4\2\2\u0101\u0100\3\2\2\2\u0102\u0105\3\2\2\2\u0103\u0101\3\2"+
		"\2\2\u0103\u0104\3\2\2\2\u0104T\3\2\2\2\u0105\u0103\3\2\2\2\u0106\u0107"+
		"\7\61\2\2\u0107\u0108\7,\2\2\u0108\u010c\3\2\2\2\u0109\u010b\13\2\2\2"+
		"\u010a\u0109\3\2\2\2\u010b\u010e\3\2\2\2\u010c\u010d\3\2\2\2\u010c\u010a"+
		"\3\2\2\2\u010d\u010f\3\2\2\2\u010e\u010c\3\2\2\2\u010f\u0110\7,\2\2\u0110"+
		"\u0111\7\61\2\2\u0111\u0112\3\2\2\2\u0112\u0113\b+\2\2\u0113V\3\2\2\2"+
		"\u0114\u0115\7\61\2\2\u0115\u0116\7\61\2\2\u0116\u011a\3\2\2\2\u0117\u0119"+
		"\n\5\2\2\u0118\u0117\3\2\2\2\u0119\u011c\3\2\2\2\u011a\u0118\3\2\2\2\u011a"+
		"\u011b\3\2\2\2\u011b\u011d\3\2\2\2\u011c\u011a\3\2\2\2\u011d\u011e\b,"+
		"\2\2\u011eX\3\2\2\2\u011f\u0121\t\6\2\2\u0120\u011f\3\2\2\2\u0121\u0122"+
		"\3\2\2\2\u0122\u0120\3\2\2\2\u0122\u0123\3\2\2\2\u0123\u0124\3\2\2\2\u0124"+
		"\u0125\b-\2\2\u0125Z\3\2\2\2\20\2\u009b\u009d\u00a9\u00ae\u00b5\u00bb"+
		"\u00c9\u00d1\u00fd\u0103\u010c\u011a\u0122\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}