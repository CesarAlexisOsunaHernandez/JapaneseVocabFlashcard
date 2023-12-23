package com.example.lamejorappparaflashcards;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {
    private static final String DB_NAME = "flashcards";
    private static final int DB_VERSION = 1;
    private final Context context;

    DatabaseHelper(Context context){
        super(context, DB_NAME, null, DB_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase db){
        db.execSQL("CREATE TABLE KATAKANA (_id INTEGER PRIMARY KEY AUTOINCREMENT, F_TEXT TEXT, B_TEXT TEXT);");

        db.execSQL("CREATE TABLE UNIT_FIVE (_id INTEGER PRIMARY KEY AUTOINCREMENT, F_TEXT TEXT, B_TEXT TEXT);");

        db.execSQL("CREATE TABLE UNIT_SIX (_id INTEGER PRIMARY KEY AUTOINCREMENT, F_TEXT TEXT, B_TEXT TEXT);");

        db.execSQL("CREATE TABLE UNIT_SEVEN (_id INTEGER PRIMARY KEY AUTOINCREMENT, F_TEXT TEXT, K_TEXT TEXT, B_TEXT TEXT);");

        db.execSQL("CREATE TABLE UNIT_EIGHT (_id INTEGER PRIMARY KEY AUTOINCREMENT, F_TEXT TEXT, K_TEXT TEXT, B_TEXT TEXT);");
}

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
        //db.execSQL("DROP TABLE MONSTER");
        db.execSQL("DROP TABLE KATAKANA");
        db.execSQL("DROP TABLE UNIT_FIVE");
        db.execSQL("DROP TABLE UNIT_SIX");
        db.execSQL("DROP TABLE UNIT_SEVEN");
        db.execSQL("DROP TABLE UNIT_EIGHT");
        updateMyDatabase(db, oldVersion, newVersion);
    }

    private static void insertCard(SQLiteDatabase db, String F_TEXT, String K_TEXT, String B_TEXT, int table){
        ContentValues cardValues = new ContentValues();
        cardValues.put("F_TEXT", F_TEXT);
        cardValues.put("K_TEXT", K_TEXT);
        cardValues.put("B_TEXT", B_TEXT);

        switch (table){
            case 4:
                db.insert("KATAKANA", null, cardValues);
                break;
            case 5:
                db.insert("UNIT_FIVE", null, cardValues);
                break;
            case 6:
                db.insert("UNIT_SIX", null, cardValues);
                break;
            case 7:
                db.insert("UNIT_SEVEN", null, cardValues);
                break;
            case 8:
                db.insert("UNIT_EIGHT", null, cardValues);
                break;
        }
    }

    private void updateMyDatabase(SQLiteDatabase db, int oldVersion, int newVersion){
        db.execSQL("CREATE TABLE KATAKANA (_id INTEGER PRIMARY KEY AUTOINCREMENT, F_TEXT TEXT, K_TEXT TEXT, B_TEXT TEXT);");
        insertCard(db, "ア", "",   "A", 4);
        insertCard(db, "イ", "",   "I", 4);
        insertCard(db, "ウ", "",   "U", 4);
        insertCard(db, "エ", "",   "E", 4);
        insertCard(db, "オ", "",   "O", 4);
        insertCard(db, "カ", "",   "KA", 4);
        insertCard(db, "キ", "",   "KI", 4);
        insertCard(db, "ク", "",   "KU", 4);
        insertCard(db, "ケ", "",   "KE", 4);
        insertCard(db, "コ", "",   "KO", 4);
        insertCard(db, "サ", "",   "SA", 4);
        insertCard(db, "シ", "",   "SHI", 4);
        insertCard(db, "ス", "",   "SU", 4);
        insertCard(db, "セ", "",   "SE", 4);
        insertCard(db, "ソ", "",   "SO", 4);
        insertCard(db, "タ", "",   "TA", 4);
        insertCard(db, "チ", "",   "CHI", 4);
        insertCard(db, "ツ", "",   "TSU", 4);
        insertCard(db, "テ", "",   "TE", 4);
        insertCard(db, "ト", "",   "TO", 4);
        insertCard(db, "ナ", "",   "NA", 4);
        insertCard(db, "二", "",   "NI", 4);
        insertCard(db, "ヌ", "",   "NU", 4);
        insertCard(db, "ネ", "",   "NE", 4);
        insertCard(db, "ノ", "",   "NO", 4);
        insertCard(db, "ハ", "",   "HA", 4);
        insertCard(db, "ヒ", "",   "HI", 4);
        insertCard(db, "フ", "",   "HU", 4);
        insertCard(db, "ヘ", "",   "HE", 4);
        insertCard(db, "ホ", "",   "HO", 4);
        insertCard(db, "マ", "",   "MA", 4);
        insertCard(db, "ミ", "",   "MI", 4);
        insertCard(db, "ム", "",   "MU", 4);
        insertCard(db, "メ", "",   "ME", 4);
        insertCard(db, "モ", "",   "MO", 4);
        insertCard(db, "ヤ", "",   "YA", 4);
        insertCard(db, "ユ", "",   "YU", 4);
        insertCard(db, "ヨ", "",   "YO", 4);
        insertCard(db, "ラ", "",   "RA", 4);
        insertCard(db, "リ", "",   "RI", 4);
        insertCard(db, "ル", "",   "RU", 4);
        insertCard(db, "レ", "",   "RE", 4);
        insertCard(db, "ロ", "",   "RO", 4);
        insertCard(db, "ワ", "",   "WA", 4);
        insertCard(db, "ヲ", "",   "WO", 4);
        insertCard(db, "ン", "",   "N", 4);


        db.execSQL("CREATE TABLE UNIT_FIVE (_id INTEGER PRIMARY KEY AUTOINCREMENT, F_TEXT TEXT, K_TEXT TEXT, B_TEXT TEXT);");
        insertCard(db, context.getString(R.string.tabemono_k),context.getString(R.string.tabemono_h),   "COMIDA", 5);
        insertCard(db, context.getString(R.string.nomimono_k),context.getString(R.string.nomimono_h),   "BEBIDA", 5);
        insertCard(db, context.getString(R.string.kudamono_k),context.getString(R.string.kudamono_h),   "FRUTAS", 5);
        insertCard(db, context.getString(R.string.yasui_k),context.getString(R.string.yasui_h),   "BARATO", 5);
        insertCard(db, context.getString(R.string.ryokou_k),context.getString(R.string.ryokou_h),   "VIAJE", 5);
        insertCard(db, context.getString(R.string.umi_k),context.getString(R.string.umi_h),   "MAR; PLAYA", 5);
        insertCard(db, context.getString(R.string.saafin_k),context.getString(R.string.saafin_h),   "SURFEAR (SURFING)", 5);
        insertCard(db, context.getString(R.string.omiyage_k),context.getString(R.string.omiyage_h),   "RECUERDITO", 5);
        insertCard(db, context.getString(R.string.basu_k),context.getString(R.string.basu_h),   "AUTOBUS (BUS)", 5);
        insertCard(db, context.getString(R.string.tenki_k),context.getString(R.string.tenki_h),   "CLIMA", 5);
        insertCard(db, context.getString(R.string.shukudai_k),context.getString(R.string.shukudai_h),   "TAREA", 5);
        insertCard(db, context.getString(R.string.testo_k),context.getString(R.string.testo_h),   "EXAMEN (TEST)", 5);
        insertCard(db, context.getString(R.string.tanjoubi_k),context.getString(R.string.tanjoubi_h),   "CUMPLEAÑOS", 5);
        insertCard(db, context.getString(R.string.heya_k),context.getString(R.string.heya_h),   "CUARTO", 5);
        insertCard(db, context.getString(R.string.boku_k),context.getString(R.string.boku_h),   "YO (MASCULINO)", 5);
        insertCard(db, context.getString(R.string.erusaizu_k),context.getString(R.string.erusaizu_h),   "TAMAÑO L (L SIZE)", 5);
        insertCard(db, context.getString(R.string.atarashii_k),context.getString(R.string.atarashii_h),   "NUEVO", 5);
        insertCard(db, context.getString(R.string.furui_k),context.getString(R.string.furui_h),   "VIEJO", 5);
        insertCard(db, context.getString(R.string.atsui_w_k),context.getString(R.string.atsui_h),   "CALIENTE (CLIMA)", 5);
        insertCard(db, context.getString(R.string.samui_k),context.getString(R.string.samui_h),   "FRIO (CLIMA)", 5);
        insertCard(db, context.getString(R.string.atsui_t_k),context.getString(R.string.atsui_h),   "CALIENTE (COSA)", 5);
        insertCard(db, context.getString(R.string.isogashii_k),context.getString(R.string.isogashii_h),   "OCUPADO", 5);
        insertCard(db, context.getString(R.string.ookii_k),context.getString(R.string.ookii_h),   "GRANDE", 5);
        insertCard(db, context.getString(R.string.chiisai_k),context.getString(R.string.chiisai_h),   "PEQUEÑO", 5);
        insertCard(db, context.getString(R.string.omoshiroi_k),context.getString(R.string.omoshiroi_h),   "INTERESANTE; DIVERTIDO", 5);
        insertCard(db, context.getString(R.string.tsumaranai_k),context.getString(R.string.tsumaranai_h),   "ABURRIDO", 5);
        insertCard(db, context.getString(R.string.yasashii_k),context.getString(R.string.yasashii_h),   "FACIL; GENTIL", 5);
        insertCard(db, context.getString(R.string.muzukashii_k),context.getString(R.string.muzukashii_h),   "DIFÍCIL", 5);
        insertCard(db, context.getString(R.string.kakkoii_k),context.getString(R.string.kakkoii_h),   "GENIAL; GUAPO", 5);
        insertCard(db, context.getString(R.string.kowai_k),context.getString(R.string.kawaii_h),   "LINDO", 5);
        insertCard(db, context.getString(R.string.tanoshii_k),context.getString(R.string.tanoshii_h),   "DIVERTIDO", 5);
        insertCard(db, context.getString(R.string.yasui_k),context.getString(R.string.yasui_h),   "BARATO", 5);
        insertCard(db, context.getString(R.string.suki_k),context.getString(R.string.suki_h),   "GUSTAR", 5);
        insertCard(db, context.getString(R.string.kirai_k),context.getString(R.string.kirai_h),   "DISGUSTAR", 5);
        insertCard(db, context.getString(R.string.daisuki_k),context.getString(R.string.daisuki_h),   "AMAR", 5);
        insertCard(db, context.getString(R.string.daikirai_k),context.getString(R.string.daikirai_h),   "ODIAR", 5);
        insertCard(db, context.getString(R.string.kirei_k),context.getString(R.string.kirei_h),   "HERMOSO; LIMPIO", 5);
        insertCard(db, context.getString(R.string.genki_k),context.getString(R.string.genki_h),   "SALUDABLE; ENERGETICO", 5);
        insertCard(db, context.getString(R.string.shizuka_k),context.getString(R.string.shizuka_h),   "SILENCIOSO", 5);
        insertCard(db, context.getString(R.string.nigiyaka_k),context.getString(R.string.nigiyaka_h),   "CONCURRIDO", 5);
        insertCard(db, context.getString(R.string.hima_k),context.getString(R.string.hima_h),   "LIBRE; DESOCUPADO", 5);
        insertCard(db, context.getString(R.string.oyogu_k),context.getString(R.string.oyogu_h),   "NADAR", 5);
        insertCard(db, context.getString(R.string.kiku_k),context.getString(R.string.kiku_h),   "PREGUNTAR", 5);
        insertCard(db, context.getString(R.string.noru_k),context.getString(R.string.noru_h),   "SUBIRSE; ANDAR EN", 5);
        insertCard(db, context.getString(R.string.yaru_k),context.getString(R.string.yaru_h),   "HACER; REALIZAR", 5);
        insertCard(db, context.getString(R.string.dekakeru_k),context.getString(R.string.dekakeru_h),   "SALIR", 5);
        insertCard(db, context.getString(R.string.isshoni_k),context.getString(R.string.isshoni_h),   "JUNTOS", 5);
        insertCard(db, context.getString(R.string.sugoku_k),context.getString(R.string.sugoku_h),   "EXTREMADAMENTE", 5);
        insertCard(db, context.getString(R.string.daijoubu_k),context.getString(R.string.daijoubu_h),   "ESTA BIEN; NO TE PREOCUPES", 5);
        insertCard(db, context.getString(R.string.totemo_k),context.getString(R.string.totemo_h),   "MUY", 5);
        insertCard(db, context.getString(R.string.donna_k),context.getString(R.string.donna_h),   "QUE TIPO DE ", 5);
        insertCard(db, context.getString(R.string.mai_k),context.getString(R.string.mai_h),   "[CONTADOR PARA OBJETOS PLANOS]", 5);

        db.execSQL("CREATE TABLE UNIT_SIX (_id INTEGER PRIMARY KEY AUTOINCREMENT, F_TEXT TEXT, K_TEXT TEXT, B_TEXT TEXT);");
        insertCard(db, "漢字", "かんじ",   context.getString(R.string.kanji_e), 6);
        insertCard(db, "教科書", "きょうかしょ",   context.getString(R.string.kyokasho_e), 6);
        insertCard(db, "ページ", "ページ",   context.getString(R.string.peeji_e), 6);
        insertCard(db, "次", "つぎ",   context.getString(R.string.tsugi_e), 6);
        insertCard(db, "お金", "おかね",   context.getString(R.string.okane_e), 6);
        insertCard(db, "荷物", "にもつ",   context.getString(R.string.nimotsu_e), 6);
        insertCard(db, "パソコン", "パソコン",   context.getString(R.string.pasokon_e), 6);
        insertCard(db, "シャワー", "シャワー",   context.getString(R.string.shawaa_e), 6);
        insertCard(db, "エアコン", "エアコン",   context.getString(R.string.eakon_e), 6);
        insertCard(db, "電気", "でんき",   context.getString(R.string.denki_e), 6);
        insertCard(db, "窓", "まど",   context.getString(R.string.mado_e), 6);
        insertCard(db, "電車", "でんしゃ",   context.getString(R.string.densha_e), 6);
        insertCard(db, "国", "くに",   context.getString(R.string.kuni_e), 6);
        insertCard(db, "今週", "こんしゅう",   context.getString(R.string.konshuu_e), 6);
        insertCard(db, "来週", "らいしゅう",   context.getString(R.string.raishuu_e), 6);
        insertCard(db, "来年", "らいねん",   context.getString(R.string.rainen_e), 6);
        insertCard(db, "夜", "よる",   context.getString(R.string.yoru_e), 6);
        insertCard(db, "大変", "たいへん",   context.getString(R.string.taihen_e), 6);
        insertCard(db, "遊ぶ", "あそぶ",   context.getString(R.string.asobu_e), 6);
        insertCard(db, "急ぐ", "いそぐ",   context.getString(R.string.isogu_e), 6);
        insertCard(db, "返す", "かえす",   context.getString(R.string.kaesu_e), 6);
        insertCard(db, "消す", "けす",   context.getString(R.string.kesu_e), 6);
        insertCard(db, "死ぬ", "しぬ",   context.getString(R.string.shinu_e), 6);
        insertCard(db, "座る", "しゅわる",   context.getString(R.string.suwaru_e), 6);
        insertCard(db, "立つ", "たつ",   context.getString(R.string.tatsu_e), 6);
        insertCard(db, "たばこを吸う", "たばこをすう",   context.getString(R.string.suu_e), 6);
        insertCard(db, "使う", "つかう",   context.getString(R.string.tsukau_e), 6);
        insertCard(db, "手伝う", "てつだう",   context.getString(R.string.tetsudau_e), 6);
        insertCard(db, "入る", "はいる",   context.getString(R.string.hairu_e), 6);
        insertCard(db, "持つ", "もつ",   context.getString(R.string.motsu_e), 6);
        insertCard(db, "休む", "やすむ",   context.getString(R.string.yasumu_e), 6);
        insertCard(db, "開ける", "あける",   context.getString(R.string.akeru_e), 6);
        insertCard(db, "閉める", "しめる",   context.getString(R.string.shimeru_e), 6);
        insertCard(db, "教える", "おしえる",   context.getString(R.string.oshieru_e), 6);
        insertCard(db, "忘れる", "わすれる",   context.getString(R.string.wasureru_e), 6);
        insertCard(db, "降りる", "おりる",   context.getString(R.string.oriru_e), 6);
        insertCard(db, "借りる", "かりる",   context.getString(R.string.kariru_e), 6);
        insertCard(db, "シャワーを浴びる", "シャワーをあびる",   context.getString(R.string.abiru_e), 6);
        insertCard(db, "つける", "つける",   context.getString(R.string.tsukeru_e), 6);
        insertCard(db, "電話する", "でんわする",   context.getString(R.string.denwasuru_e), 6);
        insertCard(db, "連れてくる", "つれてくる",   context.getString(R.string.tsuretekuru_e), 6);
        insertCard(db, "持ってくる", "もってくる",   context.getString(R.string.mottekuru_e), 6);
        insertCard(db, "後で", "あとで",   context.getString(R.string.atode_e), 6);
        insertCard(db, "すぐ", "すぐ",   context.getString(R.string.sugu_e), 6);
        insertCard(db, "ゆっくり", "ゆっくり",   context.getString(R.string.yukkuri_e), 6);
        insertCard(db, "結構です", "けっこうです",   context.getString(R.string.kekkoudesu_e), 6);
        insertCard(db, "本当ですか", "ほんとうですか",   context.getString(R.string.hontoudesuka_e), 6);

        db.execSQL("CREATE TABLE UNIT_SEVEN (_id INTEGER PRIMARY KEY AUTOINCREMENT, F_TEXT TEXT, K_TEXT TEXT, B_TEXT TEXT);");
        insertCard(db, context.getString(R.string.kazoku_k), context.getString(R.string.kazoku_h),      "FAMILIA", 7);
        insertCard(db, context.getString(R.string.ojiisan_k),context.getString(R.string.ojiisan_h),      "ABUELO; ANCIANO", 7);
        insertCard(db, context.getString(R.string.obaasan_k), context.getString(R.string.obaasan_h),       "ABUELA; ANCIANA", 7);
        insertCard(db, context.getString(R.string.oniisan_k), context.getString(R.string.oniisan_h),       "HERMANO MAYOR", 7);
        insertCard(db, context.getString(R.string.oneesan_k), context.getString(R.string.oneesan_h),       "HERMANA MAYOR", 7);
        insertCard(db, context.getString(R.string.chichi_k), context.getString(R.string.chichi_h),       "MI PAPA", 7);
        insertCard(db, context.getString(R.string.haha_k), context.getString(R.string.haha_h),   "MI MAMA", 7);
        insertCard(db, context.getString(R.string.ani_k), context.getString(R.string.ani_h),   "MI HERMANO MAYOR", 7);
        insertCard(db, context.getString(R.string.ane_k), context.getString(R.string.ane_h),   "MI HERMANA MAYOR", 7);
        insertCard(db, context.getString(R.string.imouto_k), context.getString(R.string.imouto_h),  "HERMANA MENOR", 7);
        insertCard(db, context.getString(R.string.otouto_k), context.getString(R.string.otouto_h),      "HERMANO MENOR", 7);
        insertCard(db, context.getString(R.string.kyoudai_k), context.getString(R.string.kyoudai_h),   "HERMANOS Y HERMANAS", 7);
        insertCard(db, context.getString(R.string.otokonohito_k), context.getString(R.string.otokonohito_h),     "HOMBRE", 7);
        insertCard(db, context.getString(R.string.onnanohito_k), context.getString(R.string.onnanohito_h), "MUJER", 7);
        insertCard(db, context.getString(R.string.kaisha_k), context.getString(R.string.kaisha_h),     "COMPAÑIA; EMPRESA", 7);
        insertCard(db, context.getString(R.string.shokudou_k), context.getString(R.string.shokudou_h),  "CAFETERIA; COMEDOR", 7);
        insertCard(db, context.getString(R.string.depaato_k), context.getString(R.string.depaato_h),     "CENTRO COMERCIAL", 7);
        insertCard(db, context.getString(R.string.kami_k), context.getString(R.string.kami_h),      "CABELLO", 7);
        insertCard(db, context.getString(R.string.kuchi_k), context.getString(R.string.kuchi_h),  "BOCA", 7);
        insertCard(db, context.getString(R.string.me_k), context.getString(R.string.me_h),   "OJO", 7);
        insertCard(db, context.getString(R.string.megane_k), context.getString(R.string.megane_h),"LENTES; ANTEOJOS", 7);
        insertCard(db, context.getString(R.string.uta_k), context.getString(R.string.uta_h),  "CANCION", 7);
        insertCard(db, context.getString(R.string.saakuru_k), context.getString(R.string.saakuru_h),    "ACTIVIDADES DE CLUB", 7);
        insertCard(db, context.getString(R.string.kuruma_k), context.getString(R.string.kuruma_h), "CARRO", 7);
        insertCard(db, context.getString(R.string.nagai_k), context.getString(R.string.nagai_h),     "LARGO", 7);
        insertCard(db, context.getString(R.string.mijikai_k), context.getString(R.string.mijikai_h),    "CORTO", 7);
        insertCard(db, context.getString(R.string.hayai_k), context.getString(R.string.hayai_h),     "RAPIDO", 7);
        insertCard(db, context.getString(R.string.segatakai_k), context.getString(R.string.segatakai_h),    "ALTO", 7);
        insertCard(db, context.getString(R.string.segahikui_h), context.getString(R.string.segahikui_h), "BAJO; CORTO", 7);
        insertCard(db, context.getString(R.string.atamagaii_k), context.getString(R.string.atamagaii_h),  "INTELIGENTE", 7);
        insertCard(db, context.getString(R.string.kawaii_k), context.getString(R.string.kawaii_h),  "LINDO", 7);
        insertCard(db, context.getString(R.string.shinsetsu_k), context.getString(R.string.shinsetsu_h),     "AMABLE", 7);
        insertCard(db, context.getString(R.string.benri_k), context.getString(R.string.benri_h),     "CONVENIENTE", 7);
        insertCard(db, context.getString(R.string.utau_k), context.getString(R.string.utau_h),   "CANTAR", 7);
        insertCard(db, context.getString(R.string.kaburu_k), context.getString(R.string.kaburu_h),       "PONERSE UN SOMRERO", 7);
        insertCard(db, context.getString(R.string.haku_k), context.getString(R.string.haku_h),  "PONERSE COSAS DEBAJO DE LA CINTURA", 7);
        insertCard(db, context.getString(R.string.shiru_k), context.getString(R.string.shiru_h),    "SABER", 7);
        insertCard(db, context.getString(R.string.shitteimasu_k), context.getString(R.string.shitteimasu_h),     "YO SE", 7);
        insertCard(db, context.getString(R.string.shitteimasen_k), context.getString(R.string.shitteimasen_h),    "NO SE", 7);
        insertCard(db, context.getString(R.string.sumu_k), context.getString(R.string.sumu_h),   "VIVIR EN UN LUGAR", 7);
        insertCard(db, context.getString(R.string.hataraku_k), context.getString(R.string.hataraku_h),  "TRABAJAR", 7);
        insertCard(db, context.getString(R.string.futoru_k), context.getString(R.string.futoru_h),     "ENGORDAR", 7);
        insertCard(db, context.getString(R.string.futotteimasu_k), context.getString(R.string.futotteimasu_h),      "TENER SOBREPESO", 7);
        insertCard(db, context.getString(R.string.kakeru_k), context.getString(R.string.kakeru_h),     "PONERSE LENTES", 7);
        insertCard(db, context.getString(R.string.kiru_k), context.getString(R.string.kiru_h),    "PONERSE COSAS ARRIBA DE LA CINTURA", 7);
        insertCard(db, context.getString(R.string.yaseru_k), context.getString(R.string.yaseru_h),    "ADELGASAR", 7);
        insertCard(db, context.getString(R.string.yaseteimasu_k), context.getString(R.string.yaseteimasu_h),  "SER DELGADO", 7);
        insertCard(db, context.getString(R.string.kekkonsuru_k), context.getString(R.string.kekkonsuru_h),  "ESTAR CASADO", 7);
        insertCard(db, context.getString(R.string.ga_k), context.getString(R.string.ga_h),      ",PERO", 7);
        insertCard(db, context.getString(R.string.nanimo_k), context.getString(R.string.nanimo_h),   "NADA", 7);
        insertCard(db, context.getString(R.string.nin_k), context.getString(R.string.nin_h),  "[CONTADOR PARA PERSONAS]", 7);
        insertCard(db, context.getString(R.string.hitori_k), context.getString(R.string.hitori_h),"UNA PERSONA", 7);
        insertCard(db, context.getString(R.string.futari_k), context.getString(R.string.futari_h),     "DOS PERSONAS", 7);
        insertCard(db, context.getString(R.string.betsuni_k), context.getString(R.string.betsuni_h),  "NADA EN PARTICULAR", 7);
        insertCard(db, context.getString(R.string.mochiron_k), context.getString(R.string.mochiron_h),"POR SU PUESTO", 7);
        insertCard(db, context.getString(R.string.yokkatara_k), context.getString(R.string.yokkatara_h),     "SI QUIERES", 7);

        db.execSQL("CREATE TABLE UNIT_EIGHT (_id INTEGER PRIMARY KEY AUTOINCREMENT, F_TEXT TEXT, K_TEXT TEXT, B_TEXT TEXT);");
        insertCard(db, "晴れ", "はれ",   context.getString(R.string.hare_e), 8);
        insertCard(db, "雨", "あめ",   context.getString(R.string.ame_e), 8);
        insertCard(db, "曇り", "くもり",   context.getString(R.string.kumori_e), 8);
        insertCard(db, "雪", "ゆき",   context.getString(R.string.yuki_e), 8);
        insertCard(db, "天気予報", "てんきよほう",   context.getString(R.string.tenkiyohou_e), 8);
        insertCard(db, "気温", "きおん",   context.getString(R.string.kion_e), 8);
        insertCard(db, "夏", "なつ",   context.getString(R.string.natsu_e), 8);
        insertCard(db, "冬", "ふゆ",   context.getString(R.string.fuyu_e), 8);
        insertCard(db, "今朝", "けさ",   context.getString(R.string.kesa_e), 8);
        insertCard(db, "あさって", "あさって",   context.getString(R.string.asatte_e), 8);
        insertCard(db, "毎週", "まいしゅう",   context.getString(R.string.maishuu_e), 8);
        insertCard(db, "今月", "こんげつ",   context.getString(R.string.kongetsu_e), 8);
        insertCard(db, "来月", "らいげつ",   context.getString(R.string.raigetsu_e), 8);
        insertCard(db, "会社員", "かいしゃいん",   context.getString(R.string.kaishain_e), 8);
        insertCard(db, "仕事", "しごと",   context.getString(R.string.shigoto_e), 8);
        insertCard(db, "カメラ", "カメラ",   context.getString(R.string.kamera_e), 8);
        insertCard(db, "カラオケ", "カラオケ",   context.getString(R.string.karaoke_e), 8);
        insertCard(db, "所", "ところ",   context.getString(R.string.tokoro_e), 8);
        insertCard(db, "トマト", "トマト",   context.getString(R.string.tomato_e), 8);
        insertCard(db, "はし", "はし",   context.getString(R.string.hashi_e), 8);
        insertCard(db, "パーティー", "パーティー",   context.getString(R.string.paatii_e), 8);
        insertCard(db, "バーベキュー", "バーベキュー",   context.getString(R.string.baabekyuu_e), 8);
        insertCard(db, "ホームステイ", "ホームステイ",   context.getString(R.string.hoomusutei_e), 8);
        insertCard(db, "お風呂", "おふろ",   context.getString(R.string.ofuro_e), 8);
        insertCard(db, "スペイン", "スパイン",   context.getString(R.string.supein_e), 8);
        insertCard(db, "何か", "なにか",   context.getString(R.string.nanika_e), 8);
        insertCard(db, "上手", "じょうず",   context.getString(R.string.jouzu_e), 8);
        insertCard(db, "下手", "へた",   context.getString(R.string.heta_e), 8);
        insertCard(db, "有名", "ゆうめい",   context.getString(R.string.yuumei_e), 8);
        insertCard(db, "洗う", "あらう",   context.getString(R.string.arau_e), 8);
        insertCard(db, "言う", "いう",   context.getString(R.string.iu_e), 8);
        insertCard(db, "いる", "いる",   context.getString(R.string.iru_e), 8);
        insertCard(db, "遅くなる", "おそくなる",   context.getString(R.string.osokunaru_e), 8);
        insertCard(db, "お風呂に入る", "おふろにはいる",   context.getString(R.string.ofuronihairu_e), 8);
        insertCard(db, "思う", "おもう",   context.getString(R.string.omou_e), 8);
        insertCard(db, "切る", "きる",   context.getString(R.string.kiru_e), 8);
        insertCard(db, "作る", "つくる",   context.getString(R.string.tsukuru_e), 8);
        insertCard(db, "降る", "ふる",   context.getString(R.string.furu_e), 8);
        insertCard(db, "持っていく", "もっていく",   context.getString(R.string.motteiku_e), 8);
        insertCard(db, "捨てる", "すてる",   context.getString(R.string.suteru_e), 8);
        insertCard(db, "始める", "はじめる",   context.getString(R.string.hajimeru_e), 8);
        insertCard(db, "運転する", "うんてんする",   context.getString(R.string.untensuru_e), 8);
        insertCard(db, "洗濯する", "せんたくする",   context.getString(R.string.sentakusuru_e), 8);
        insertCard(db, "掃除する", "そうじする",   context.getString(R.string.soujisuru_e), 8);
        insertCard(db, "料理する", "りょうりする",   context.getString(R.string.ryourisuru_e), 8);
        insertCard(db, "うん", "うん",   context.getString(R.string.un_e), 8);
        insertCard(db, "ううん", "ううん",   context.getString(R.string.uun_e), 8);
        insertCard(db, "いつも", "いつも",   context.getString(R.string.itsumo_e), 8);
        insertCard(db, "遅く", "おそく",   context.getString(R.string.osoku_e), 8);
        insertCard(db, "乾杯", "かんぱい",   context.getString(R.string.kanpai_e), 8);
        insertCard(db, "みんなで", "みんなで",   context.getString(R.string.minnade_e), 8);
        insertCard(db, "残念ですね", "ざんねんですね",   context.getString(R.string.zannendesune_e), 8);
        insertCard(db, "まだ", "まだ",   context.getString(R.string.mada_e), 8);
        insertCard(db, "ーについて", "ーについて",   context.getString(R.string.nitsuite_e), 8);
        insertCard(db, "ー度", "ーど",   context.getString(R.string.do_e), 8);
        insertCard(db, "どう", "どう",   context.getString(R.string.dou_e), 8);
    }

    @Override
    public void onOpen (SQLiteDatabase db) {
        //db.execSQL("DROP TABLE MONSTER");
        db.execSQL("DROP TABLE KATAKANA");
        db.execSQL("DROP TABLE UNIT_FIVE");
        db.execSQL("DROP TABLE UNIT_SIX");
        db.execSQL("DROP TABLE UNIT_SEVEN");
        db.execSQL("DROP TABLE UNIT_EIGHT");
        updateMyDatabase(db, 1, 2);
    }
}
