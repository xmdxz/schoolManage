package com;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.UnsupportedEncodingException;
import java.util.Random;

/**
 * @Author RainGoal
 * @Date 2021/2/3 15:33
 * @Description TODO
 * @Version 1.0
 */

public class CreatData {

    public static void main(String[] args) {
        String name = "";
        String familyNameStr = "";
        Random random = new Random();
        int id = 10004;
        String[] banji = {"01","02","03","04","05","06","07","08","09","10","11","12","13","14","15","16","17","18",
                "19","20","21","22"};
        String[] sex = {"男","女"};
        String[] position = {"班长","学委","心理委员","副班长","体育委员","组织委员","宣传委员","团支书","无","无","无","无","无","无","无","无","无","无","无","无","无","无","无","无","无","无","无","无","无","无","无","无","无","无","无","无","无","无","无","无"};
        String[] major = {"软件工程","大数据","数字媒体技术","智能科学技术"};
        int[] bedroom = {1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20};
        for (int i=0;i<1001;i++){
            Student student = new Student();
            Boolean flag = random.nextBoolean();
            familyNameStr = getChineseFamilyName();
            name = familyNameStr;
            if (flag){
                name+=getChineseGivenName()+getChineseGivenName();
            }else name+=getChineseGivenName();
            student.setName(name);
            student.setClno("软件学院");
            student.setBank("88888888888888");
            student.setComy("2019");
            student.setId(Integer.toString(id+1));
            student.setIdcard("140987200107349988");
            student.setPresent_class("19"+ banji[random.nextInt(22)]);
            student.setOriginal_class("19"+banji[random.nextInt(22)]);
            student.setReligion("佛教");
            student.setNation("汉");
            student.setSex(sex[random.nextInt(2)]);
            student.setBedroom_lou(Integer.toString(bedroom[random.nextInt(20)])+"号楼");
            student.setPresent_post(position[random.nextInt(40)]);
            student.setOriginal_post(position[random.nextInt(40)]);
            student.setMajor(major[random.nextInt(4)]);
            System.out.println(student);
            id = id+1;
        }

    }

    public static String getChineseFamilyName() {

        String str = null;

        Random random = new Random();

        /* 598 百家姓 */

        String[] Surname = {"赵", "钱", "孙", "李", "周", "吴", "郑", "王", "冯", "陈", "褚", "卫", "蒋", "沈", "韩", "杨", "朱", "秦", "尤", "许",

                "何", "吕", "施", "张", "孔", "曹", "严", "华", "金", "魏", "陶", "姜", "戚", "谢", "邹", "喻", "柏", "水", "窦", "章", "云", "苏", "潘", "葛", "奚", "范", "彭", "郎",

                "鲁", "韦", "昌", "马", "苗", "凤", "花", "方", "俞", "任", "袁", "柳", "酆", "鲍", "史", "唐", "费", "廉", "岑", "薛", "雷", "贺", "倪", "汤", "滕", "殷",

                "罗", "毕", "郝", "邬", "安", "常", "乐", "于", "时", "傅", "皮", "卞", "齐", "康", "伍", "余", "元", "卜", "顾", "孟", "平", "黄", "和",

                "穆", "萧", "尹", "姚", "邵", "湛", "汪", "祁", "毛", "禹", "狄", "米", "贝", "明", "臧", "计", "伏", "成", "戴", "谈", "宋", "茅", "庞", "熊", "纪", "舒",

                "屈", "项", "祝", "董", "梁", "杜", "阮", "蓝", "闵", "席", "季", "麻", "强", "贾", "路", "娄", "危", "江", "童", "颜", "郭", "梅", "盛", "林", "刁", "钟",

                "徐", "邱", "骆", "高", "夏", "蔡", "田", "樊", "胡", "凌", "霍", "虞", "万", "支", "柯", "昝", "管", "卢", "莫", "经", "房", "裘", "缪", "干", "解", "应",

                "宗", "丁", "宣", "贲", "邓", "郁", "单", "杭", "洪", "包", "诸", "左", "石", "崔", "吉", "钮", "龚", "程", "嵇", "邢", "滑", "裴", "陆", "荣", "翁", "荀",

                "羊", "于", "惠", "甄", "曲", "家", "封", "芮", "羿", "储", "靳", "汲", "邴", "糜", "松", "井", "段", "富", "巫", "乌", "焦", "巴", "弓", "牧", "隗", "山",

                "谷", "车", "侯", "宓", "蓬", "全", "郗", "班", "仰", "秋", "仲", "伊", "宫", "宁", "仇", "栾", "暴", "甘", "钭", "厉", "戎", "祖", "武", "符", "刘", "景",

                "詹", "束", "龙", "叶", "幸", "司", "韶", "郜", "黎", "蓟", "溥", "印", "宿", "白", "怀", "蒲", "邰", "从", "鄂", "索", "咸", "籍", "赖", "卓", "蔺", "屠",

                "蒙", "池", "乔", "阴", "郁", "胥", "能", "苍", "双", "闻", "莘", "党", "翟", "谭", "贡", "劳", "逄", "姬", "申", "扶", "堵", "冉", "宰", "郦", "雍", "却",

                "璩", "桑", "桂", "濮", "牛", "寿", "通", "边", "扈", "燕", "冀", "浦", "尚", "农", "温", "别", "庄", "晏", "柴", "瞿", "阎", "充", "慕", "连", "茹", "习",

                "宦", "艾", "鱼", "容", "向", "古", "易", "慎", "戈", "廖", "庾", "终", "暨", "居", "衡", "步", "都", "耿", "满", "弘", "匡", "国", "文", "寇", "广", "禄",

                "阙", "东", "欧", "殳", "沃", "利", "蔚", "越", "夔", "隆", "师", "巩", "厍", "聂", "晁", "勾", "敖", "融", "冷", "訾", "辛", "阚", "那", "简", "饶", "空",

                "曾", "毋", "沙", "乜", "养", "鞠", "须", "丰", "巢", "关", "蒯", "相", "查", "后", "荆", "红", "游", "郏", "竺", "权", "逯", "盖", "益", "桓", "公", "仉",

                "督", "岳", "帅", "缑", "亢", "况", "郈", "有", "琴", "归", "海", "晋", "楚", "闫", "法", "汝", "鄢", "涂", "钦", "商", "牟", "佘", "佴", "伯", "赏", "墨",

                "哈", "谯", "篁", "年", "爱", "阳", "佟", "言", "福", "南", "火", "铁", "迟", "漆", "官", "冼", "真", "展", "繁", "檀", "祭", "密", "敬", "揭", "舜", "楼",

                "疏", "冒", "浑", "挚", "胶", "随", "高", "皋", "原", "种", "练", "弥", "仓", "眭", "蹇", "覃", "阿", "门", "恽", "来", "綦", "召", "仪", "风", "介", "巨",

                "木", "京", "狐", "郇", "虎", "枚", "抗", "达", "杞", "苌", "折", "麦", "庆", "过", "竹", "端", "鲜", "皇", "亓", "老", "是", "秘", "畅", "邝", "还", "宾",

                "闾", "辜", "纵", "侴", "万俟", "司马", "上官", "欧阳", "夏侯", "诸葛", "闻人", "东方", "赫连", "皇甫", "羊舌", "尉迟", "公羊", "澹台", "公冶", "宗正",

                "濮阳", "淳于", "单于", "太叔", "申屠", "公孙", "仲孙", "轩辕", "令狐", "钟离", "宇文", "长孙", "慕容", "鲜于", "闾丘", "司徒", "司空", "兀官", "司寇",

                "南门", "呼延", "子车", "颛孙", "端木", "巫马", "公西", "漆雕", "车正", "壤驷", "公良", "拓跋", "夹谷", "宰父", "谷梁", "段干", "百里", "东郭", "微生",

                "梁丘", "左丘", "东门", "西门", "南宫", "第五", "公仪", "公乘", "太史", "仲长", "叔孙", "屈突", "尔朱", "东乡", "相里", "胡母", "司城", "张廖", "雍门",

                "毋丘", "贺兰", "綦毋", "屋庐", "独孤", "南郭", "北宫", "王孙"};

        int index = random.nextInt(Surname.length - 1);

        str = Surname[index]; //获得一个随机的姓氏

        return str;
    }

    public static String getChineseGivenName() {

        String str = null;

        int highPos, lowPos;

        Random random = new Random();

        highPos = (176 + Math.abs(random.nextInt(71)));//区码，0xA0打头，从第16区开始，即0xB0=11*16=176,16~55一级汉字，56~87二级汉字

        random = new Random();

        lowPos = 161 + Math.abs(random.nextInt(94));//位码，0xA0打头，范围第1~94列


        byte[] bArr = new byte[2];

        bArr[0] = (new Integer(highPos)).byteValue();

        bArr[1] = (new Integer(lowPos)).byteValue();

        try {

            str = new String(bArr, "GB2312");//区位码组合成汉字

        } catch (UnsupportedEncodingException e) {

            e.printStackTrace();

        }

        return str;

    }

    public static boolean writeContent(String c, String path, boolean isAppend) {

//File f = new File(path);

        try {

            FileOutputStream fos = new FileOutputStream(path, isAppend);

            OutputStreamWriter writer = new OutputStreamWriter(fos, "UTF-8");

            writer.write(c);

            writer.close();

            fos.close();

        } catch (IOException e) {

            e.printStackTrace();

            return false;

        }

        return true;

    }
}
