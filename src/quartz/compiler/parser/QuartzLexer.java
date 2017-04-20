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
		T__24=25, T__25=26, T__26=27, T__27=28, T__28=29, T__29=30, T__30=31, 
		T__31=32, T__32=33, T__33=34, T__34=35, T__35=36, T__36=37, T__37=38, 
		T__38=39, T__39=40, T__40=41, T__41=42, T__42=43, T__43=44, T__44=45, 
		T__45=46, T__46=47, DMOD=48, STRING=49, CHAR=50, INT=51, DOUBLE=52, INLINE_C=53, 
		IDENTIFIER=54, BLOCK_COMMENT=55, LINE_COMMENT=56, WHITESPACE=57;
	public static String[] modeNames = {
		"DEFAULT_MODE"
	};

	public static final String[] ruleNames = {
		"T__0", "T__1", "T__2", "T__3", "T__4", "T__5", "T__6", "T__7", "T__8", 
		"T__9", "T__10", "T__11", "T__12", "T__13", "T__14", "T__15", "T__16", 
		"T__17", "T__18", "T__19", "T__20", "T__21", "T__22", "T__23", "T__24", 
		"T__25", "T__26", "T__27", "T__28", "T__29", "T__30", "T__31", "T__32", 
		"T__33", "T__34", "T__35", "T__36", "T__37", "T__38", "T__39", "T__40", 
		"T__41", "T__42", "T__43", "T__44", "T__45", "T__46", "DMOD", "STRING", 
		"CHAR", "INT", "DOUBLE", "INLINE_C", "IDENTIFIER", "BLOCK_COMMENT", "LINE_COMMENT", 
		"WHITESPACE"
	};

	private static final String[] _LITERAL_NAMES = {
		null, "'fn'", "'<'", "'>'", "'('", "')'", "':'", "'extern'", "','", "'='", 
		"'struct'", "'{'", "'}'", "'typealias'", "'destructor'", "'import'", "'.'", 
		"'return'", "'if'", "'else'", "'while'", "'delete'", "'typeswitch'", "'||'", 
		"'&&'", "'+='", "'-='", "'*='", "'/='", "'%='", "'=='", "'!='", "'>='", 
		"'<='", "'+'", "'-'", "'*'", "'/'", "'%'", "'++'", "'--'", "'!'", "'sizeof'", 
		"'->'", "'...'", "'var'", "'val'", "';'", "'%%'"
	};
	private static final String[] _SYMBOLIC_NAMES = {
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		null, null, null, null, null, null, null, null, null, null, null, null, 
		"DMOD", "STRING", "CHAR", "INT", "DOUBLE", "INLINE_C", "IDENTIFIER", "BLOCK_COMMENT", 
		"LINE_COMMENT", "WHITESPACE"
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
		"\3\u0430\ud6d1\u8206\uad2d\u4417\uaef1\u8d80\uaadd\2;\u017b\b\1\4\2\t"+
		"\2\4\3\t\3\4\4\t\4\4\5\t\5\4\6\t\6\4\7\t\7\4\b\t\b\4\t\t\t\4\n\t\n\4\13"+
		"\t\13\4\f\t\f\4\r\t\r\4\16\t\16\4\17\t\17\4\20\t\20\4\21\t\21\4\22\t\22"+
		"\4\23\t\23\4\24\t\24\4\25\t\25\4\26\t\26\4\27\t\27\4\30\t\30\4\31\t\31"+
		"\4\32\t\32\4\33\t\33\4\34\t\34\4\35\t\35\4\36\t\36\4\37\t\37\4 \t \4!"+
		"\t!\4\"\t\"\4#\t#\4$\t$\4%\t%\4&\t&\4\'\t\'\4(\t(\4)\t)\4*\t*\4+\t+\4"+
		",\t,\4-\t-\4.\t.\4/\t/\4\60\t\60\4\61\t\61\4\62\t\62\4\63\t\63\4\64\t"+
		"\64\4\65\t\65\4\66\t\66\4\67\t\67\48\t8\49\t9\4:\t:\3\2\3\2\3\2\3\3\3"+
		"\3\3\4\3\4\3\5\3\5\3\6\3\6\3\7\3\7\3\b\3\b\3\b\3\b\3\b\3\b\3\b\3\t\3\t"+
		"\3\n\3\n\3\13\3\13\3\13\3\13\3\13\3\13\3\13\3\f\3\f\3\r\3\r\3\16\3\16"+
		"\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\16\3\17\3\17\3\17\3\17\3\17\3\17"+
		"\3\17\3\17\3\17\3\17\3\17\3\20\3\20\3\20\3\20\3\20\3\20\3\20\3\21\3\21"+
		"\3\22\3\22\3\22\3\22\3\22\3\22\3\22\3\23\3\23\3\23\3\24\3\24\3\24\3\24"+
		"\3\24\3\25\3\25\3\25\3\25\3\25\3\25\3\26\3\26\3\26\3\26\3\26\3\26\3\26"+
		"\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\27\3\30\3\30\3\30"+
		"\3\31\3\31\3\31\3\32\3\32\3\32\3\33\3\33\3\33\3\34\3\34\3\34\3\35\3\35"+
		"\3\35\3\36\3\36\3\36\3\37\3\37\3\37\3 \3 \3 \3!\3!\3!\3\"\3\"\3\"\3#\3"+
		"#\3$\3$\3%\3%\3&\3&\3\'\3\'\3(\3(\3(\3)\3)\3)\3*\3*\3+\3+\3+\3+\3+\3+"+
		"\3+\3,\3,\3,\3-\3-\3-\3-\3.\3.\3.\3.\3/\3/\3/\3/\3\60\3\60\3\61\3\61\3"+
		"\61\3\62\3\62\3\62\3\62\7\62\u0130\n\62\f\62\16\62\u0133\13\62\3\62\3"+
		"\62\3\63\3\63\3\63\3\63\3\64\6\64\u013c\n\64\r\64\16\64\u013d\3\65\7\65"+
		"\u0141\n\65\f\65\16\65\u0144\13\65\3\65\3\65\6\65\u0148\n\65\r\65\16\65"+
		"\u0149\3\66\3\66\7\66\u014e\n\66\f\66\16\66\u0151\13\66\3\66\3\66\3\67"+
		"\3\67\7\67\u0157\n\67\f\67\16\67\u015a\13\67\38\38\38\38\78\u0160\n8\f"+
		"8\168\u0163\138\38\38\38\38\38\39\39\39\39\79\u016e\n9\f9\169\u0171\13"+
		"9\39\39\3:\6:\u0176\n:\r:\16:\u0177\3:\3:\5\u0131\u014f\u0161\2;\3\3\5"+
		"\4\7\5\t\6\13\7\r\b\17\t\21\n\23\13\25\f\27\r\31\16\33\17\35\20\37\21"+
		"!\22#\23%\24\'\25)\26+\27-\30/\31\61\32\63\33\65\34\67\359\36;\37= ?!"+
		"A\"C#E$G%I&K\'M(O)Q*S+U,W-Y.[/]\60_\61a\62c\63e\64g\65i\66k\67m8o9q:s"+
		";\3\2\7\3\2\62;\5\2C\\aac|\6\2\62;C\\aac|\4\2\f\f\17\17\5\2\13\f\17\17"+
		"\"\"\u0184\2\3\3\2\2\2\2\5\3\2\2\2\2\7\3\2\2\2\2\t\3\2\2\2\2\13\3\2\2"+
		"\2\2\r\3\2\2\2\2\17\3\2\2\2\2\21\3\2\2\2\2\23\3\2\2\2\2\25\3\2\2\2\2\27"+
		"\3\2\2\2\2\31\3\2\2\2\2\33\3\2\2\2\2\35\3\2\2\2\2\37\3\2\2\2\2!\3\2\2"+
		"\2\2#\3\2\2\2\2%\3\2\2\2\2\'\3\2\2\2\2)\3\2\2\2\2+\3\2\2\2\2-\3\2\2\2"+
		"\2/\3\2\2\2\2\61\3\2\2\2\2\63\3\2\2\2\2\65\3\2\2\2\2\67\3\2\2\2\29\3\2"+
		"\2\2\2;\3\2\2\2\2=\3\2\2\2\2?\3\2\2\2\2A\3\2\2\2\2C\3\2\2\2\2E\3\2\2\2"+
		"\2G\3\2\2\2\2I\3\2\2\2\2K\3\2\2\2\2M\3\2\2\2\2O\3\2\2\2\2Q\3\2\2\2\2S"+
		"\3\2\2\2\2U\3\2\2\2\2W\3\2\2\2\2Y\3\2\2\2\2[\3\2\2\2\2]\3\2\2\2\2_\3\2"+
		"\2\2\2a\3\2\2\2\2c\3\2\2\2\2e\3\2\2\2\2g\3\2\2\2\2i\3\2\2\2\2k\3\2\2\2"+
		"\2m\3\2\2\2\2o\3\2\2\2\2q\3\2\2\2\2s\3\2\2\2\3u\3\2\2\2\5x\3\2\2\2\7z"+
		"\3\2\2\2\t|\3\2\2\2\13~\3\2\2\2\r\u0080\3\2\2\2\17\u0082\3\2\2\2\21\u0089"+
		"\3\2\2\2\23\u008b\3\2\2\2\25\u008d\3\2\2\2\27\u0094\3\2\2\2\31\u0096\3"+
		"\2\2\2\33\u0098\3\2\2\2\35\u00a2\3\2\2\2\37\u00ad\3\2\2\2!\u00b4\3\2\2"+
		"\2#\u00b6\3\2\2\2%\u00bd\3\2\2\2\'\u00c0\3\2\2\2)\u00c5\3\2\2\2+\u00cb"+
		"\3\2\2\2-\u00d2\3\2\2\2/\u00dd\3\2\2\2\61\u00e0\3\2\2\2\63\u00e3\3\2\2"+
		"\2\65\u00e6\3\2\2\2\67\u00e9\3\2\2\29\u00ec\3\2\2\2;\u00ef\3\2\2\2=\u00f2"+
		"\3\2\2\2?\u00f5\3\2\2\2A\u00f8\3\2\2\2C\u00fb\3\2\2\2E\u00fe\3\2\2\2G"+
		"\u0100\3\2\2\2I\u0102\3\2\2\2K\u0104\3\2\2\2M\u0106\3\2\2\2O\u0108\3\2"+
		"\2\2Q\u010b\3\2\2\2S\u010e\3\2\2\2U\u0110\3\2\2\2W\u0117\3\2\2\2Y\u011a"+
		"\3\2\2\2[\u011e\3\2\2\2]\u0122\3\2\2\2_\u0126\3\2\2\2a\u0128\3\2\2\2c"+
		"\u012b\3\2\2\2e\u0136\3\2\2\2g\u013b\3\2\2\2i\u0142\3\2\2\2k\u014b\3\2"+
		"\2\2m\u0154\3\2\2\2o\u015b\3\2\2\2q\u0169\3\2\2\2s\u0175\3\2\2\2uv\7h"+
		"\2\2vw\7p\2\2w\4\3\2\2\2xy\7>\2\2y\6\3\2\2\2z{\7@\2\2{\b\3\2\2\2|}\7*"+
		"\2\2}\n\3\2\2\2~\177\7+\2\2\177\f\3\2\2\2\u0080\u0081\7<\2\2\u0081\16"+
		"\3\2\2\2\u0082\u0083\7g\2\2\u0083\u0084\7z\2\2\u0084\u0085\7v\2\2\u0085"+
		"\u0086\7g\2\2\u0086\u0087\7t\2\2\u0087\u0088\7p\2\2\u0088\20\3\2\2\2\u0089"+
		"\u008a\7.\2\2\u008a\22\3\2\2\2\u008b\u008c\7?\2\2\u008c\24\3\2\2\2\u008d"+
		"\u008e\7u\2\2\u008e\u008f\7v\2\2\u008f\u0090\7t\2\2\u0090\u0091\7w\2\2"+
		"\u0091\u0092\7e\2\2\u0092\u0093\7v\2\2\u0093\26\3\2\2\2\u0094\u0095\7"+
		"}\2\2\u0095\30\3\2\2\2\u0096\u0097\7\177\2\2\u0097\32\3\2\2\2\u0098\u0099"+
		"\7v\2\2\u0099\u009a\7{\2\2\u009a\u009b\7r\2\2\u009b\u009c\7g\2\2\u009c"+
		"\u009d\7c\2\2\u009d\u009e\7n\2\2\u009e\u009f\7k\2\2\u009f\u00a0\7c\2\2"+
		"\u00a0\u00a1\7u\2\2\u00a1\34\3\2\2\2\u00a2\u00a3\7f\2\2\u00a3\u00a4\7"+
		"g\2\2\u00a4\u00a5\7u\2\2\u00a5\u00a6\7v\2\2\u00a6\u00a7\7t\2\2\u00a7\u00a8"+
		"\7w\2\2\u00a8\u00a9\7e\2\2\u00a9\u00aa\7v\2\2\u00aa\u00ab\7q\2\2\u00ab"+
		"\u00ac\7t\2\2\u00ac\36\3\2\2\2\u00ad\u00ae\7k\2\2\u00ae\u00af\7o\2\2\u00af"+
		"\u00b0\7r\2\2\u00b0\u00b1\7q\2\2\u00b1\u00b2\7t\2\2\u00b2\u00b3\7v\2\2"+
		"\u00b3 \3\2\2\2\u00b4\u00b5\7\60\2\2\u00b5\"\3\2\2\2\u00b6\u00b7\7t\2"+
		"\2\u00b7\u00b8\7g\2\2\u00b8\u00b9\7v\2\2\u00b9\u00ba\7w\2\2\u00ba\u00bb"+
		"\7t\2\2\u00bb\u00bc\7p\2\2\u00bc$\3\2\2\2\u00bd\u00be\7k\2\2\u00be\u00bf"+
		"\7h\2\2\u00bf&\3\2\2\2\u00c0\u00c1\7g\2\2\u00c1\u00c2\7n\2\2\u00c2\u00c3"+
		"\7u\2\2\u00c3\u00c4\7g\2\2\u00c4(\3\2\2\2\u00c5\u00c6\7y\2\2\u00c6\u00c7"+
		"\7j\2\2\u00c7\u00c8\7k\2\2\u00c8\u00c9\7n\2\2\u00c9\u00ca\7g\2\2\u00ca"+
		"*\3\2\2\2\u00cb\u00cc\7f\2\2\u00cc\u00cd\7g\2\2\u00cd\u00ce\7n\2\2\u00ce"+
		"\u00cf\7g\2\2\u00cf\u00d0\7v\2\2\u00d0\u00d1\7g\2\2\u00d1,\3\2\2\2\u00d2"+
		"\u00d3\7v\2\2\u00d3\u00d4\7{\2\2\u00d4\u00d5\7r\2\2\u00d5\u00d6\7g\2\2"+
		"\u00d6\u00d7\7u\2\2\u00d7\u00d8\7y\2\2\u00d8\u00d9\7k\2\2\u00d9\u00da"+
		"\7v\2\2\u00da\u00db\7e\2\2\u00db\u00dc\7j\2\2\u00dc.\3\2\2\2\u00dd\u00de"+
		"\7~\2\2\u00de\u00df\7~\2\2\u00df\60\3\2\2\2\u00e0\u00e1\7(\2\2\u00e1\u00e2"+
		"\7(\2\2\u00e2\62\3\2\2\2\u00e3\u00e4\7-\2\2\u00e4\u00e5\7?\2\2\u00e5\64"+
		"\3\2\2\2\u00e6\u00e7\7/\2\2\u00e7\u00e8\7?\2\2\u00e8\66\3\2\2\2\u00e9"+
		"\u00ea\7,\2\2\u00ea\u00eb\7?\2\2\u00eb8\3\2\2\2\u00ec\u00ed\7\61\2\2\u00ed"+
		"\u00ee\7?\2\2\u00ee:\3\2\2\2\u00ef\u00f0\7\'\2\2\u00f0\u00f1\7?\2\2\u00f1"+
		"<\3\2\2\2\u00f2\u00f3\7?\2\2\u00f3\u00f4\7?\2\2\u00f4>\3\2\2\2\u00f5\u00f6"+
		"\7#\2\2\u00f6\u00f7\7?\2\2\u00f7@\3\2\2\2\u00f8\u00f9\7@\2\2\u00f9\u00fa"+
		"\7?\2\2\u00faB\3\2\2\2\u00fb\u00fc\7>\2\2\u00fc\u00fd\7?\2\2\u00fdD\3"+
		"\2\2\2\u00fe\u00ff\7-\2\2\u00ffF\3\2\2\2\u0100\u0101\7/\2\2\u0101H\3\2"+
		"\2\2\u0102\u0103\7,\2\2\u0103J\3\2\2\2\u0104\u0105\7\61\2\2\u0105L\3\2"+
		"\2\2\u0106\u0107\7\'\2\2\u0107N\3\2\2\2\u0108\u0109\7-\2\2\u0109\u010a"+
		"\7-\2\2\u010aP\3\2\2\2\u010b\u010c\7/\2\2\u010c\u010d\7/\2\2\u010dR\3"+
		"\2\2\2\u010e\u010f\7#\2\2\u010fT\3\2\2\2\u0110\u0111\7u\2\2\u0111\u0112"+
		"\7k\2\2\u0112\u0113\7|\2\2\u0113\u0114\7g\2\2\u0114\u0115\7q\2\2\u0115"+
		"\u0116\7h\2\2\u0116V\3\2\2\2\u0117\u0118\7/\2\2\u0118\u0119\7@\2\2\u0119"+
		"X\3\2\2\2\u011a\u011b\7\60\2\2\u011b\u011c\7\60\2\2\u011c\u011d\7\60\2"+
		"\2\u011dZ\3\2\2\2\u011e\u011f\7x\2\2\u011f\u0120\7c\2\2\u0120\u0121\7"+
		"t\2\2\u0121\\\3\2\2\2\u0122\u0123\7x\2\2\u0123\u0124\7c\2\2\u0124\u0125"+
		"\7n\2\2\u0125^\3\2\2\2\u0126\u0127\7=\2\2\u0127`\3\2\2\2\u0128\u0129\7"+
		"\'\2\2\u0129\u012a\7\'\2\2\u012ab\3\2\2\2\u012b\u0131\7$\2\2\u012c\u012d"+
		"\7^\2\2\u012d\u0130\13\2\2\2\u012e\u0130\13\2\2\2\u012f\u012c\3\2\2\2"+
		"\u012f\u012e\3\2\2\2\u0130\u0133\3\2\2\2\u0131\u0132\3\2\2\2\u0131\u012f"+
		"\3\2\2\2\u0132\u0134\3\2\2\2\u0133\u0131\3\2\2\2\u0134\u0135\7$\2\2\u0135"+
		"d\3\2\2\2\u0136\u0137\7)\2\2\u0137\u0138\13\2\2\2\u0138\u0139\7)\2\2\u0139"+
		"f\3\2\2\2\u013a\u013c\t\2\2\2\u013b\u013a\3\2\2\2\u013c\u013d\3\2\2\2"+
		"\u013d\u013b\3\2\2\2\u013d\u013e\3\2\2\2\u013eh\3\2\2\2\u013f\u0141\t"+
		"\2\2\2\u0140\u013f\3\2\2\2\u0141\u0144\3\2\2\2\u0142\u0140\3\2\2\2\u0142"+
		"\u0143\3\2\2\2\u0143\u0145\3\2\2\2\u0144\u0142\3\2\2\2\u0145\u0147\7\60"+
		"\2\2\u0146\u0148\t\2\2\2\u0147\u0146\3\2\2\2\u0148\u0149\3\2\2\2\u0149"+
		"\u0147\3\2\2\2\u0149\u014a\3\2\2\2\u014aj\3\2\2\2\u014b\u014f\5a\61\2"+
		"\u014c\u014e\13\2\2\2\u014d\u014c\3\2\2\2\u014e\u0151\3\2\2\2\u014f\u0150"+
		"\3\2\2\2\u014f\u014d\3\2\2\2\u0150\u0152\3\2\2\2\u0151\u014f\3\2\2\2\u0152"+
		"\u0153\5a\61\2\u0153l\3\2\2\2\u0154\u0158\t\3\2\2\u0155\u0157\t\4\2\2"+
		"\u0156\u0155\3\2\2\2\u0157\u015a\3\2\2\2\u0158\u0156\3\2\2\2\u0158\u0159"+
		"\3\2\2\2\u0159n\3\2\2\2\u015a\u0158\3\2\2\2\u015b\u015c\7\61\2\2\u015c"+
		"\u015d\7,\2\2\u015d\u0161\3\2\2\2\u015e\u0160\13\2\2\2\u015f\u015e\3\2"+
		"\2\2\u0160\u0163\3\2\2\2\u0161\u0162\3\2\2\2\u0161\u015f\3\2\2\2\u0162"+
		"\u0164\3\2\2\2\u0163\u0161\3\2\2\2\u0164\u0165\7,\2\2\u0165\u0166\7\61"+
		"\2\2\u0166\u0167\3\2\2\2\u0167\u0168\b8\2\2\u0168p\3\2\2\2\u0169\u016a"+
		"\7\61\2\2\u016a\u016b\7\61\2\2\u016b\u016f\3\2\2\2\u016c\u016e\n\5\2\2"+
		"\u016d\u016c\3\2\2\2\u016e\u0171\3\2\2\2\u016f\u016d\3\2\2\2\u016f\u0170"+
		"\3\2\2\2\u0170\u0172\3\2\2\2\u0171\u016f\3\2\2\2\u0172\u0173\b9\2\2\u0173"+
		"r\3\2\2\2\u0174\u0176\t\6\2\2\u0175\u0174\3\2\2\2\u0176\u0177\3\2\2\2"+
		"\u0177\u0175\3\2\2\2\u0177\u0178\3\2\2\2\u0178\u0179\3\2\2\2\u0179\u017a"+
		"\b:\2\2\u017at\3\2\2\2\r\2\u012f\u0131\u013d\u0142\u0149\u014f\u0158\u0161"+
		"\u016f\u0177\3\b\2\2";
	public static final ATN _ATN =
		new ATNDeserializer().deserialize(_serializedATN.toCharArray());
	static {
		_decisionToDFA = new DFA[_ATN.getNumberOfDecisions()];
		for (int i = 0; i < _ATN.getNumberOfDecisions(); i++) {
			_decisionToDFA[i] = new DFA(_ATN.getDecisionState(i), i);
		}
	}
}