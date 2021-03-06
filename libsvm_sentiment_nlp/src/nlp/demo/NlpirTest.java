package nlp.demo;



import org.junit.Test;

import nlp.demo.NlpirMethod;

/**
 * 分词组件测试
 * 
 * @author move
 *
 */
public class NlpirTest {
	
	
	
	/**
	 * 测试文本分词
	 */
	@Test
	public void testParagraphProcess(){
		String content = "_`这是最近-下 ；单号~ ！为：1442083355，其中一套书《易经的智慧》当当网  少带< <光盘 。为了得到解决，我去信两次，二三天无人回复。  然后我打电话[08/1/04 1:30]010-51236699客服热线，分机为3037。反映情况。当当网的回复令人失望，让我把书全面寄回去，办理换货。说不管哪儿个 人都是这样处理的。我说这样多麻烦，你们把忘带的光带寄过来不行吗。当当网说，不行。这样的小事，这样的处理，个人感觉，在当当网购物，不出现麻烦罢了，一出现，你就倒霉了！我也不计划要光盘了，不会把书再寄回去 、 、 、 、 、 、，因为他们这样的态度，让我不放心。我自认倒霉。只是考虑往后不在当当网购书。";
		String result = NlpirMethod.NLPIR_ParagraphProcess(content, 1);
		
		String[] s = result.split(" ");
		StringBuffer a=new StringBuffer();
		StringBuffer a2=new StringBuffer();
		for(int i=0;i<s.length;i++){
			if(s[i].contains("/e")||s[i].contains("/t")||s[i].contains("/w")||s[i].contains("/m")||s[i].contains("/n")||s[i].contains("/ude1")){
				
			}else{
				String b=s[i].replaceAll("/|[a-z]", "");
				String b2=s[i];
				a.append(b+" ");
				a2.append(b2+" ");
			}
			
		}
		System.out.println(a2);
		System.out.println(a);
	}

	/**
	 * 测试文本路径分词
	 */
	@Test
	public void testFileProcess(){
		double flag = NlpirMethod.NLPIR_FileProcess("D:\\tmp\\new-cs-1.txt", "D:\\tmp\\new-traindata.txt", 1);
		System.out.println(flag);
	}

	/**
	 * 测试细粒度分词
	 */
	@Test
	public void testFinerSegment(){
		String content = "据俄罗斯卫星网8月11日发布美国《国家利益》杂志刊登的文章称，中国购买俄制苏-27第四代战机，为本国空军翻开了现代史的页章。" +
				"从那时起，中国空军日益强大。中国空军长期以来落后于像美国这样的世界大国，从2008年起中国开始研制堪舆美国F-22猛禽战机和F-35闪电-II相媲美的第五代战机J-20和J-31，" +
				"不仅用它们装备本国空军，而且还在国际市场销售。它让中国具有了远程打击的能力，能达到西太平洋的任何地点。J-31可能成为J-20的有力补充，是理想的战机，能在西太平洋切断重要地区。" +
				"J-31升空后，完全能应对美国的F-35。这些战机能从根本上改变中国同美国以及同台湾地区冲突的走向。如果中国大陆通过台湾海峡进攻台湾(解放军每年都要进行这方面的演练)，" +
				"因为拥有最先进的战机而具有的空中优势是解放军进攻取胜的关键因素。这无疑应当引起美国的不安，无论是从战略上，还是从战术上以及从机动性上，美国《国家利益》警告。";
		String result = NlpirMethod.NLPIR_FinerSegment(content);
		System.out.println(result);
	}

	/**
	 * 测试文本关键词
	 */
	@Test
	public void testKeyWords(){
		String content = "D:\\tmp\\new-cs.txt";
		String result = NlpirMethod.NLPIR_GetKeyWords(content, 100, true);
		System.out.println(result);
	}

	/**
	 * 测试文本路径关键词
	 */
	@Test
	public void testFileKeyWords(){
		String result = NlpirMethod.NLPIR_GetFileKeyWords("D:\\tmp\\new-cs.txt", 100, true);
		System.out.println(result);
	}

	/**
	 * 测试文本新词(有时文本太短，没有新词)
	 */
	@Test
	public void testNewWords(){
		String content = "D:\\tmp\\new-cs.txt";
		String result = NlpirMethod.NLPIR_GetNewWords(content, 100, true);
		System.out.println("迷");
		System.out.println(result);
	}

	/**
	 * 测试文本路径新词(有时文本太短，没有新词)
	 */
	@Test
	public void testFileNewWords(){
		String result = NlpirMethod.NLPIR_GetFileNewWords("test/source.txt", 100, true);
		System.out.println(result);
	}

	/**
	 * 测试添加用户自定义词
	 */
	@Test
	public void testAddUserWord(){
		int flag1 = NlpirMethod.NLPIR_AddUserWord("俄罗斯卫星");
		System.out.println(flag1);
		
		int flag2 = NlpirMethod.NLPIR_SaveTheUsrDic();
		System.out.println(flag2);
		
		String content = "据俄罗斯卫星网8月11日发布美国《国家利益》杂志刊登的文章称，中国购买俄制苏-27第四代战机，为本国空军翻开了现代史的页章。" +
				"从那时起，中国空军日益强大。中国空军长期以来落后于像美国这样的世界大国，从2008年起中国开始研制堪舆美国F-22猛禽战机和F-35闪电-II相媲美的第五代战机J-20和J-31，" +
				"不仅用它们装备本国空军，而且还在国际市场销售。它让中国具有了远程打击的能力，能达到西太平洋的任何地点。J-31可能成为J-20的有力补充，是理想的战机，能在西太平洋切断重要地区。" +
				"J-31升空后，完全能应对美国的F-35。这些战机能从根本上改变中国同美国以及同台湾地区冲突的走向。如果中国大陆通过台湾海峡进攻台湾(解放军每年都要进行这方面的演练)，" +
				"因为拥有最先进的战机而具有的空中优势是解放军进攻取胜的关键因素。这无疑应当引起美国的不安，无论是从战略上，还是从战术上以及从机动性上，美国《国家利益》警告。";
		String result = NlpirMethod.NLPIR_ParagraphProcess(content, 0);
		System.out.println(result);
	}

	/**
	 * 测试删除用户自定义词
	 */
	@Test
	public void testDelUsrWord(){
		int flag1 = NlpirMethod.NLPIR_DelUsrWord("俄罗斯");
		System.out.println(flag1);
		
		int flag2 = NlpirMethod.NLPIR_SaveTheUsrDic();
		System.out.println(flag2);
		
		String content = "据俄罗斯卫星网8月11日发布美国《国家利益》杂志刊登的文章称，中国购买俄制苏-27第四代战机，为本国空军翻开了现代史的页章。" +
				"从那时起，中国空军日益强大。中国空军长期以来落后于像美国这样的世界大国，从2008年起中国开始研制堪舆美国F-22猛禽战机和F-35闪电-II相媲美的第五代战机J-20和J-31，" +
				"不仅用它们装备本国空军，而且还在国际市场销售。它让中国具有了远程打击的能力，能达到西太平洋的任何地点。J-31可能成为J-20的有力补充，是理想的战机，能在西太平洋切断重要地区。" +
				"J-31升空后，完全能应对美国的F-35。这些战机能从根本上改变中国同美国以及同台湾地区冲突的走向。如果中国大陆通过台湾海峡进攻台湾(解放军每年都要进行这方面的演练)，" +
				"因为拥有最先进的战机而具有的空中优势是解放军进攻取胜的关键因素。这无疑应当引起美国的不安，无论是从战略上，还是从战术上以及从机动性上，美国《国家利益》警告。";
		String result = NlpirMethod.NLPIR_ParagraphProcess(content, 0);
		System.out.println(result);
	}

	/**
	 * 测试导入用户词典
	 */
	@Test
	public void testImportUserDict(){
		int flag = NlpirMethod.NLPIR_ImportUserDict("dict/user_dict.txt", true);
		String content = "据俄罗斯卫星网8月11日发布美国《国家利益》杂志刊登的文章称，中国购买俄制苏-27第四代战机，为本国空军翻开了现代史的页章。" +
				"从那时起，中国空军日益强大。中国空军长期以来落后于像美国这样的世界大国，从2008年起中国开始研制堪舆美国F-22猛禽战机和F-35闪电-II相媲美的第五代战机J-20和J-31，" +
				"不仅用它们装备本国空军，而且还在国际市场销售。它让中国具有了远程打击的能力，能达到西太平洋的任何地点。J-31可能成为J-20的有力补充，是理想的战机，能在西太平洋切断重要地区。" +
				"J-31升空后，完全能应对美国的F-35。这些战机能从根本上改变中国同美国以及同台湾地区冲突的走向。如果中国大陆通过台湾海峡进攻台湾(解放军每年都要进行这方面的演练)，" +
				"因为拥有最先进的战机而具有的空中优势是解放军进攻取胜的关键因素。这无疑应当引起美国的不安，无论是从战略上，还是从战术上以及从机动性上，美国《国家利益》警告。";
		String result = NlpirMethod.NLPIR_ParagraphProcess(content, 1);
		System.out.println(flag);
		System.out.println(result);
	}

	/**
	 * 测试导入关键词黑名单
	 */
	@Test
	public void testImportKeyBlack(){
		int flag = NlpirMethod.NLPIR_ImportKeyBlackList("dict/black_dict.txt");
		System.out.println(flag);
		
		String content = "据俄罗斯卫星网8月11日发布美国《国家利益》杂志刊登的文章称，中国购买俄制苏-27第四代战机，为本国空军翻开了现代史的页章。" +
				"从那时起，中国空军日益强大。中国空军长期以来落后于像美国这样的世界大国，从2008年起中国开始研制堪舆美国F-22猛禽战机和F-35闪电-II相媲美的第五代战机J-20和J-31，" +
				"不仅用它们装备本国空军，而且还在国际市场销售。它让中国具有了远程打击的能力，能达到西太平洋的任何地点。J-31可能成为J-20的有力补充，是理想的战机，能在西太平洋切断重要地区。" +
				"J-31升空后，完全能应对美国的F-35。这些战机能从根本上改变中国同美国以及同台湾地区冲突的走向。如果中国大陆通过台湾海峡进攻台湾(解放军每年都要进行这方面的演练)，" +
				"因为拥有最先进的战机而具有的空中优势是解放军进攻取胜的关键因素。这无疑应当引起美国的不安，无论是从战略上，还是从战术上以及从机动性上，美国《国家利益》警告。";
		String result = NlpirMethod.NLPIR_ParagraphProcess(content, 1);
		System.out.println(result);
		
	}

	/**
	 * 测试文章指纹码
	 */
	@Test
	public void testFingerPrint(){
		String content = "日前，网友上传了052D型驱逐舰173号长沙舰在蓝色水面上航行照片。有网友猜测，长沙舰已经交付南海舰队，是中国海军已列装的第二艘，同时也是最新一艘的052D型神盾级驱逐舰。" +
				"新闻延伸：英国《简氏防务周刊》近日再次谈及中国海军更新换代的热点话题，报道称，中国第二艘052D型导弹驱逐舰长沙舰于7月中旬服役，并已加入解放军南海舰队，预计将部署到海南岛亚龙湾基地。" +
				"它是这种中国最先进驱逐舰的第二艘，首舰昆明舰于2014年3月服役，并进行了一系列广泛的系统测试。报道称“052D与之前的型号相比，武器系统的主要变化是更换了新型相控阵雷达和通用型垂直发射系统，" +
				"后者可以同时容纳防空导弹、反潜导弹、反舰导弹和巡航导弹。因此需要花费较长时间进行密集测试。”让西方吃惊的是这种新型驱逐舰的建造速度。据称第七艘052D型驱逐舰已于7月下水，江南造船厂的船台上还在建造第八和第九艘。" +
				"052D型驱逐舰的建造规模已达到12艘，其中4艘将配属未来航母战斗群。它舰长160米、宽18米，排水量超过7000吨，作战性能居解放军海军主力舰只之首。除了导弹驱逐舰外，054A新型导弹护卫舰的建造速度也同样让外界吃惊。" +
				"《简氏防务周刊》称，扬州舰和邯郸舰已交付中国海军，它们分别是054A型导弹护卫舰的第19和第20艘。在上海和广州的造船厂中，各自还在建造两艘同级护卫舰。054A型护卫舰的首舰于2008年服役，它被视为中国第一种区域防空型护卫舰，" +
				"外形采用隐身设计，并配备有新型垂直发射系统。它曾参加过国际远航活动、索马里反海盗等，为中国海军累积了可观的远洋经验。对于中国的军舰更新速度，西方一直保持警惕。美国海军报告认为，中国海军造舰速度已经远超其他国家，" +
				"以现有速度扩充下去，很可能在2020年超过美国海军。不过有分析认为，无论是现有舰队组成还是每年更新的舰艇类型，中国海军的更新换代暂时还处于“补旧账”阶段，远谈不上超过美国海军。";
		long flag = NlpirMethod.NLPIR_FingerPrint(content);
		System.out.println(flag);
	}

	/**
	 * 测试单词词性
	 */
	@Test
	public void testWordPOS(){
		String result = NlpirMethod.NLPIR_GetWordPOS("中国");
		System.out.println(result);
	}

	/**
	 * 测试是否在词库中
	 */
	@Test
	public void testIsWord(){
		int flag = NlpirMethod.NLPIR_IsWord("中国");
		System.out.println(flag);
	}

	/**
	 * 测试文本词频
	 */
	@Test
	public void testWordFreq(){
		String content = "据俄罗斯卫星网8月11日发布美国《国家利益》杂志刊登的文章称，中国购买俄制苏-27第四代战机，为本国空军翻开了现代史的页章。" +
				"从那时起，中国空军日益强大。中国空军长期以来落后于像美国这样的世界大国，从2008年起中国开始研制堪舆美国F-22猛禽战机和F-35闪电-II相媲美的第五代战机J-20和J-31，" +
				"不仅用它们装备本国空军，而且还在国际市场销售。它让中国具有了远程打击的能力，能达到西太平洋的任何地点。J-31可能成为J-20的有力补充，是理想的战机，能在西太平洋切断重要地区。" +
				"J-31升空后，完全能应对美国的F-35。这些战机能从根本上改变中国同美国以及同台湾地区冲突的走向。如果中国大陆通过台湾海峡进攻台湾(解放军每年都要进行这方面的演练)，" +
				"因为拥有最先进的战机而具有的空中优势是解放军进攻取胜的关键因素。这无疑应当引起美国的不安，无论是从战略上，还是从战术上以及从机动性上，美国《国家利益》警告。";
		String result = NlpirMethod.NLPIR_WordFreqStat(content);
		System.out.println(result);
	}

	/**
	 * 测试文本路径词频
	 */
	@Test
	public void testFileWordFreq(){
		String result = NlpirMethod.NLPIR_FileWordFreqStat("neg3.txt");
		System.out.println(result);
	}

	/**
	 * 测试英文单词原型
	 */
	@Test
	public void testEngWordOrign(){
		String result = NlpirMethod.NLPIR_GetEngWordOrign("got");
		System.out.println(result);
	}
}
