package com.example.lamejorappparaflashcards;

import android.content.ContentValues;
import android.content.Context;
import android.database.DatabaseUtils;
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
        insertCard(db, "ア", "",   "A", "KATAKANA");
        insertCard(db, "イ", "",   "I", "KATAKANA");
        insertCard(db, "ウ", "",   "U", "KATAKANA");
        insertCard(db, "エ", "",   "E", "KATAKANA");
        insertCard(db, "オ", "",   "O", "KATAKANA");
        insertCard(db, "カ", "",   "KA", "KATAKANA");
        insertCard(db, "キ", "",   "KI", "KATAKANA");
        insertCard(db, "ク", "",   "KU", "KATAKANA");
        insertCard(db, "ケ", "",   "KE", "KATAKANA");
        insertCard(db, "コ", "",   "KO", "KATAKANA");
        insertCard(db, "サ", "",   "SA", "KATAKANA");
        insertCard(db, "シ", "",   "SHI", "KATAKANA");
        insertCard(db, "ス", "",   "SU", "KATAKANA");
        insertCard(db, "セ", "",   "SE", "KATAKANA");
        insertCard(db, "ソ", "",   "SO", "KATAKANA");
        insertCard(db, "タ", "",   "TA", "KATAKANA");
        insertCard(db, "チ", "",   "CHI", "KATAKANA");
        insertCard(db, "ツ", "",   "TSU", "KATAKANA");
        insertCard(db, "テ", "",   "TE", "KATAKANA");
        insertCard(db, "ト", "",   "TO", "KATAKANA");
        insertCard(db, "ナ", "",   "NA", "KATAKANA");
        insertCard(db, "二", "",   "NI", "KATAKANA");
        insertCard(db, "ヌ", "",   "NU", "KATAKANA");
        insertCard(db, "ネ", "",   "NE", "KATAKANA");
        insertCard(db, "ノ", "",   "NO", "KATAKANA");
        insertCard(db, "ハ", "",   "HA", "KATAKANA");
        insertCard(db, "ヒ", "",   "HI", "KATAKANA");
        insertCard(db, "フ", "",   "HU", "KATAKANA");
        insertCard(db, "ヘ", "",   "HE", "KATAKANA");
        insertCard(db, "ホ", "",   "HO", "KATAKANA");
        insertCard(db, "マ", "",   "MA", "KATAKANA");
        insertCard(db, "ミ", "",   "MI", "KATAKANA");
        insertCard(db, "ム", "",   "MU", "KATAKANA");
        insertCard(db, "メ", "",   "ME", "KATAKANA");
        insertCard(db, "モ", "",   "MO", "KATAKANA");
        insertCard(db, "ヤ", "",   "YA", "KATAKANA");
        insertCard(db, "ユ", "",   "YU", "KATAKANA");
        insertCard(db, "ヨ", "",   "YO", "KATAKANA");
        insertCard(db, "ラ", "",   "RA", "KATAKANA");
        insertCard(db, "リ", "",   "RI", "KATAKANA");
        insertCard(db, "ル", "",   "RU", "KATAKANA");
        insertCard(db, "レ", "",   "RE", "KATAKANA");
        insertCard(db, "ロ", "",   "RO", "KATAKANA");
        insertCard(db, "ワ", "",   "WA", "KATAKANA");
        insertCard(db, "ヲ", "",   "WO", "KATAKANA");
        insertCard(db, "ン", "",   "N", "KATAKANA");

        db.execSQL("CREATE TABLE UNIT_FIVE (_id INTEGER PRIMARY KEY AUTOINCREMENT, F_TEXT TEXT, B_TEXT TEXT);");
        insertCard(db, context.getString(R.string.tabemono_k),context.getString(R.string.tabemono_h),   "COMIDA", "UNIT_FIVE");
        insertCard(db, context.getString(R.string.nomimono_k),context.getString(R.string.nomimono_h),   "BEBIDA", "UNIT_FIVE");
        insertCard(db, context.getString(R.string.kudamono_k),context.getString(R.string.kudamono_h),   "FRUTAS", "UNIT_FIVE");
        insertCard(db, context.getString(R.string.yasui_k),context.getString(R.string.yasui_h),   "BARATO", "UNIT_FIVE");
        insertCard(db, context.getString(R.string.ryokou_k),context.getString(R.string.ryokou_h),   "VIAJE", "UNIT_FIVE");
        insertCard(db, context.getString(R.string.umi_k),context.getString(R.string.umi_h),   "MAR; PLAYA", "UNIT_FIVE");
        insertCard(db, context.getString(R.string.saafin_k),context.getString(R.string.saafin_h),   "SURFEAR (SURFING)", "UNIT_FIVE");
        insertCard(db, context.getString(R.string.omiyage_k),context.getString(R.string.omiyage_h),   "RECUERDITO", "UNIT_FIVE");
        insertCard(db, context.getString(R.string.basu_k),context.getString(R.string.basu_h),   "AUTOBUS (BUS)", "UNIT_FIVE");
        insertCard(db, context.getString(R.string.tenki_k),context.getString(R.string.tenki_h),   "CLIMA", "UNIT_FIVE");
        insertCard(db, context.getString(R.string.shukudai_k),context.getString(R.string.shukudai_h),   "TAREA", "UNIT_FIVE");
        insertCard(db, context.getString(R.string.testo_k),context.getString(R.string.testo_h),   "EXAMEN (TEST)", "UNIT_FIVE");
        insertCard(db, context.getString(R.string.tanjoubi_k),context.getString(R.string.tanjoubi_h),   "CUMPLEAÑOS", "UNIT_FIVE");
        insertCard(db, context.getString(R.string.heya_k),context.getString(R.string.heya_h),   "CUARTO", "UNIT_FIVE");
        insertCard(db, context.getString(R.string.boku_k),context.getString(R.string.boku_h),   "YO (MASCULINO)", "UNIT_FIVE");
        insertCard(db, context.getString(R.string.erusaizu_k),context.getString(R.string.erusaizu_h),   "TAMAÑO L (L SIZE)", "UNIT_FIVE");
        insertCard(db, context.getString(R.string.atarashii_k),context.getString(R.string.atarashii_h),   "NUEVO", "UNIT_FIVE");
        insertCard(db, context.getString(R.string.furui_k),context.getString(R.string.furui_h),   "VIEJO", "UNIT_FIVE");
        insertCard(db, context.getString(R.string.atsui_w_k),context.getString(R.string.atsui_h),   "CALIENTE (CLIMA)", "UNIT_FIVE");
        insertCard(db, context.getString(R.string.samui_k),context.getString(R.string.samui_h),   "FRIO (CLIMA)", "UNIT_FIVE");
        insertCard(db, context.getString(R.string.atsui_t_k),context.getString(R.string.atsui_h),   "CALIENTE (COSA)", "UNIT_FIVE");
        insertCard(db, context.getString(R.string.isogashii_k),context.getString(R.string.isogashii_h),   "OCUPADO", "UNIT_FIVE");
        insertCard(db, context.getString(R.string.ookii_k),context.getString(R.string.ookii_h),   "GRANDE", "UNIT_FIVE");
        insertCard(db, context.getString(R.string.chiisai_k),context.getString(R.string.chiisai_h),   "PEQUEÑO", "UNIT_FIVE");
        insertCard(db, context.getString(R.string.omoshiroi_k),context.getString(R.string.omoshiroi_h),   "INTERESANTE; DIVERTIDO", "UNIT_FIVE");
        insertCard(db, context.getString(R.string.tsumaranai_k),context.getString(R.string.tsumaranai_h),   "ABURRIDO", "UNIT_FIVE");
        insertCard(db, context.getString(R.string.yasashii_k),context.getString(R.string.yasashii_h),   "FACIL; GENTIL", "UNIT_FIVE");
        insertCard(db, context.getString(R.string.muzukashii_k),context.getString(R.string.muzukashii_h),   "DIFÍCIL", "UNIT_FIVE");
        insertCard(db, context.getString(R.string.kakkoii_k),context.getString(R.string.kakkoii_h),   "GENIAL; GUAPO", "UNIT_FIVE");
        insertCard(db, context.getString(R.string.kowai_k),context.getString(R.string.kawaii_h),   "LINDO", "UNIT_FIVE");
        insertCard(db, context.getString(R.string.tanoshii_k),context.getString(R.string.tanoshii_h),   "DIVERTIDO", "UNIT_FIVE");
        insertCard(db, context.getString(R.string.yasui_k),context.getString(R.string.yasui_h),   "BARATO", "UNIT_FIVE");
        insertCard(db, context.getString(R.string.suki_k),context.getString(R.string.suki_h),   "GUSTAR", "UNIT_FIVE");
        insertCard(db, context.getString(R.string.kirai_k),context.getString(R.string.kirai_h),   "DISGUSTAR", "UNIT_FIVE");
        insertCard(db, context.getString(R.string.daisuki_k),context.getString(R.string.daisuki_h),   "AMAR", "UNIT_FIVE");
        insertCard(db, context.getString(R.string.daikirai_k),context.getString(R.string.daikirai_h),   "ODIAR", "UNIT_FIVE");
        insertCard(db, context.getString(R.string.kirei_k),context.getString(R.string.kirei_h),   "HERMOSO; LIMPIO", "UNIT_FIVE");
        insertCard(db, context.getString(R.string.genki_k),context.getString(R.string.genki_h),   "SALUDABLE; ENERGETICO", "UNIT_FIVE");
        insertCard(db, context.getString(R.string.shizuka_k),context.getString(R.string.shizuka_h),   "SILENCIOSO", "UNIT_FIVE");
        insertCard(db, context.getString(R.string.nigiyaka_k),context.getString(R.string.nigiyaka_h),   "CONCURRIDO", "UNIT_FIVE");
        insertCard(db, context.getString(R.string.hima_k),context.getString(R.string.hima_h),   "LIBRE; DESOCUPADO", "UNIT_FIVE");
        insertCard(db, context.getString(R.string.oyogu_k),context.getString(R.string.oyogu_h),   "NADAR", "UNIT_FIVE");
        insertCard(db, context.getString(R.string.kiku_k),context.getString(R.string.kiku_h),   "PREGUNTAR", "UNIT_FIVE");
        insertCard(db, context.getString(R.string.noru_k),context.getString(R.string.noru_h),   "SUBIRSE; ANDAR EN", "UNIT_FIVE");
        insertCard(db, context.getString(R.string.yaru_k),context.getString(R.string.yaru_h),   "HACER; REALIZAR", "UNIT_FIVE");
        insertCard(db, context.getString(R.string.dekakeru_k),context.getString(R.string.dekakeru_h),   "SALIR", "UNIT_FIVE");
        insertCard(db, context.getString(R.string.isshoni_k),context.getString(R.string.isshoni_h),   "JUNTOS", "UNIT_FIVE");
        insertCard(db, context.getString(R.string.sugoku_k),context.getString(R.string.sugoku_h),   "EXTREMADAMENTE", "UNIT_FIVE");
        insertCard(db, context.getString(R.string.daijoubu_k),context.getString(R.string.daijoubu_h),   "ESTA BIEN; NO TE PREOCUPES", "UNIT_FIVE");
        insertCard(db, context.getString(R.string.totemo_k),context.getString(R.string.totemo_h),   "MUY", "UNIT_FIVE");
        insertCard(db, context.getString(R.string.donna_k),context.getString(R.string.donna_h),   "QUE TIPO DE ", "UNIT_FIVE");
        insertCard(db, context.getString(R.string.mai_k),context.getString(R.string.mai_h),   "[CONTADOR PARA OBJETOS PLANOS]", "UNIT_FIVE");

        db.execSQL("CREATE TABLE UNIT_SIX (_id INTEGER PRIMARY KEY AUTOINCREMENT, F_TEXT TEXT, B_TEXT TEXT);");
        insertCard(db, "漢字", "かんじ",   context.getString(R.string.kanji_e), "UNIT_SIX");
        insertCard(db, "教科書", "きょうかしょ",   context.getString(R.string.kyokasho_e), "UNIT_SIX");
        insertCard(db, "ページ", "ページ",   context.getString(R.string.peeji_e), "UNIT_SIX");
        insertCard(db, "次", "つぎ",   context.getString(R.string.tsugi_e), "UNIT_SIX");
        insertCard(db, "お金", "おかね",   context.getString(R.string.okane_e), "UNIT_SIX");
        insertCard(db, "荷物", "にもつ",   context.getString(R.string.nimotsu_e), "UNIT_SIX");
        insertCard(db, "パソコン", "パソコン",   context.getString(R.string.pasokon_e), "UNIT_SIX");
        insertCard(db, "シャワー", "シャワー",   context.getString(R.string.shawaa_e), "UNIT_SIX");
        insertCard(db, "エアコン", "エアコン",   context.getString(R.string.eakon_e), "UNIT_SIX");
        insertCard(db, "電気", "でんき",   context.getString(R.string.denki_e), "UNIT_SIX");
        insertCard(db, "窓", "まど",   context.getString(R.string.mado_e), "UNIT_SIX");
        insertCard(db, "電車", "でんしゃ",   context.getString(R.string.densha_e), "UNIT_SIX");
        insertCard(db, "国", "くに",   context.getString(R.string.kuni_e), "UNIT_SIX");
        insertCard(db, "今週", "こんしゅう",   context.getString(R.string.konshuu_e), "UNIT_SIX");
        insertCard(db, "来週", "らいしゅう",   context.getString(R.string.raishuu_e), "UNIT_SIX");
        insertCard(db, "来年", "らいねん",   context.getString(R.string.rainen_e), "UNIT_SIX");
        insertCard(db, "夜", "よる",   context.getString(R.string.yoru_e), "UNIT_SIX");
        insertCard(db, "大変", "たいへん",   context.getString(R.string.taihen_e), "UNIT_SIX");
        insertCard(db, "遊ぶ", "あそぶ",   context.getString(R.string.asobu_e), "UNIT_SIX");
        insertCard(db, "急ぐ", "いそぐ",   context.getString(R.string.isogu_e), "UNIT_SIX");
        insertCard(db, "返す", "かえす",   context.getString(R.string.kaesu_e), "UNIT_SIX");
        insertCard(db, "消す", "けす",   context.getString(R.string.kesu_e), "UNIT_SIX");
        insertCard(db, "死ぬ", "しぬ",   context.getString(R.string.shinu_e), "UNIT_SIX");
        insertCard(db, "座る", "しゅわる",   context.getString(R.string.suwaru_e), "UNIT_SIX");
        insertCard(db, "立つ", "たつ",   context.getString(R.string.tatsu_e), "UNIT_SIX");
        insertCard(db, "たばこを吸う", "たばこをすう",   context.getString(R.string.suu_e), "UNIT_SIX");
        insertCard(db, "使う", "つかう",   context.getString(R.string.tsukau_e), "UNIT_SIX");
        insertCard(db, "手伝う", "てつだう",   context.getString(R.string.tetsudau_e), "UNIT_SIX");
        insertCard(db, "入る", "はいる",   context.getString(R.string.hairu_e), "UNIT_SIX");
        insertCard(db, "持つ", "もつ",   context.getString(R.string.motsu_e), "UNIT_SIX");
        insertCard(db, "休む", "やすむ",   context.getString(R.string.yasumu_e), "UNIT_SIX");
        insertCard(db, "開ける", "あける",   context.getString(R.string.akeru_e), "UNIT_SIX");
        insertCard(db, "閉める", "しめる",   context.getString(R.string.shimeru_e), "UNIT_SIX");
        insertCard(db, "教える", "おしえる",   context.getString(R.string.oshieru_e), "UNIT_SIX");
        insertCard(db, "忘れる", "わすれる",   context.getString(R.string.wasureru_e), "UNIT_SIX");
        insertCard(db, "降りる", "おりる",   context.getString(R.string.oriru_e), "UNIT_SIX");
        insertCard(db, "借りる", "かりる",   context.getString(R.string.kariru_e), "UNIT_SIX");
        insertCard(db, "シャワーを浴びる", "シャワーをあびる",   context.getString(R.string.abiru_e), "UNIT_SIX");
        insertCard(db, "つける", "つける",   context.getString(R.string.tsukeru_e), "UNIT_SIX");
        insertCard(db, "電話する", "でんわする",   context.getString(R.string.denwasuru_e), "UNIT_SIX");
        insertCard(db, "連れてくる", "つれてくる",   context.getString(R.string.tsuretekuru_e), "UNIT_SIX");
        insertCard(db, "持ってくる", "もってくる",   context.getString(R.string.mottekuru_e), "UNIT_SIX");
        insertCard(db, "後で", "あとで",   context.getString(R.string.atode_e), "UNIT_SIX");
        insertCard(db, "すぐ", "すぐ",   context.getString(R.string.sugu_e), "UNIT_SIX");
        insertCard(db, "ゆっくり", "ゆっくり",   context.getString(R.string.yukkuri_e), "UNIT_SIX");
        insertCard(db, "結構です", "けっこうです",   context.getString(R.string.kekkoudesu_e), "UNIT_SIX");
        insertCard(db, "本当ですか", "ほんとうですか",   context.getString(R.string.hontoudesuka_e), "UNIT_SIX");

        db.execSQL("CREATE TABLE UNIT_SEVEN (_id INTEGER PRIMARY KEY AUTOINCREMENT, F_TEXT TEXT, K_TEXT TEXT, B_TEXT TEXT);");
        insertCard(db, context.getString(R.string.kazoku_k), context.getString(R.string.kazoku_h),      "FAMILIA", "UNIT_SEVEN");
        insertCard(db, context.getString(R.string.ojiisan_k),context.getString(R.string.ojiisan_h),      "ABUELO; ANCIANO", "UNIT_SEVEN");
        insertCard(db, context.getString(R.string.obaasan_k), context.getString(R.string.obaasan_h),       "ABUELA; ANCIANA", "UNIT_SEVEN");
        insertCard(db, context.getString(R.string.oniisan_k), context.getString(R.string.oniisan_h),       "HERMANO MAYOR", "UNIT_SEVEN");
        insertCard(db, context.getString(R.string.oneesan_k), context.getString(R.string.oneesan_h),       "HERMANA MAYOR", "UNIT_SEVEN");
        insertCard(db, context.getString(R.string.chichi_k), context.getString(R.string.chichi_h),       "MI PAPA", "UNIT_SEVEN");
        insertCard(db, context.getString(R.string.haha_k), context.getString(R.string.haha_h),   "MI MAMA", "UNIT_SEVEN");
        insertCard(db, context.getString(R.string.ani_k), context.getString(R.string.ani_h),   "MI HERMANO MAYOR", "UNIT_SEVEN");
        insertCard(db, context.getString(R.string.ane_k), context.getString(R.string.ane_h),   "MI HERMANA MAYOR", "UNIT_SEVEN");
        insertCard(db, context.getString(R.string.imouto_k), context.getString(R.string.imouto_h),  "HERMANA MENOR", "UNIT_SEVEN");
        insertCard(db, context.getString(R.string.otouto_k), context.getString(R.string.otouto_h),      "HERMANO MENOR", "UNIT_SEVEN");
        insertCard(db, context.getString(R.string.kyoudai_k), context.getString(R.string.kyoudai_h),   "HERMANOS Y HERMANAS", "UNIT_SEVEN");
        insertCard(db, context.getString(R.string.otokonohito_k), context.getString(R.string.otokonohito_h),     "HOMBRE", "UNIT_SEVEN");
        insertCard(db, context.getString(R.string.onnanohito_k), context.getString(R.string.onnanohito_h), "MUJER", "UNIT_SEVEN");
        insertCard(db, context.getString(R.string.kaisha_k), context.getString(R.string.kaisha_h),     "COMPAÑIA; EMPRESA", "UNIT_SEVEN");
        insertCard(db, context.getString(R.string.shokudou_k), context.getString(R.string.shokudou_h),  "CAFETERIA; COMEDOR", "UNIT_SEVEN");
        insertCard(db, context.getString(R.string.depaato_k), context.getString(R.string.depaato_h),     "CENTRO COMERCIAL", "UNIT_SEVEN");
        insertCard(db, context.getString(R.string.kami_k), context.getString(R.string.kami_h),      "CABELLO", "UNIT_SEVEN");
        insertCard(db, context.getString(R.string.kuchi_k), context.getString(R.string.kuchi_h),  "BOCA", "UNIT_SEVEN");
        insertCard(db, context.getString(R.string.me_k), context.getString(R.string.me_h),   "OJO", "UNIT_SEVEN");
        insertCard(db, context.getString(R.string.megane_k), context.getString(R.string.megane_h),"LENTES; ANTEOJOS", "UNIT_SEVEN");
        insertCard(db, context.getString(R.string.uta_k), context.getString(R.string.uta_h),  "CANCION", "UNIT_SEVEN");
        insertCard(db, context.getString(R.string.saakuru_k), context.getString(R.string.saakuru_h),    "ACTIVIDADES DE CLUB", "UNIT_SEVEN");
        insertCard(db, context.getString(R.string.kuruma_k), context.getString(R.string.kuruma_h), "CARRO", "UNIT_SEVEN");
        insertCard(db, context.getString(R.string.nagai_k), context.getString(R.string.nagai_h),     "LARGO", "UNIT_SEVEN");
        insertCard(db, context.getString(R.string.mijikai_k), context.getString(R.string.mijikai_h),    "CORTO", "UNIT_SEVEN");
        insertCard(db, context.getString(R.string.hayai_k), context.getString(R.string.hayai_h),     "RAPIDO", "UNIT_SEVEN");
        insertCard(db, context.getString(R.string.segatakai_k), context.getString(R.string.segatakai_h),    "ALTO", "UNIT_SEVEN");
        insertCard(db, context.getString(R.string.segahikui_k), context.getString(R.string.segahikui_h), "BAJO; CORTO", "UNIT_SEVEN");
        insertCard(db, context.getString(R.string.atamagaii_k), context.getString(R.string.atamagaii_h),  "INTELIGENTE", "UNIT_SEVEN");
        insertCard(db, context.getString(R.string.kawaii_k), context.getString(R.string.kawaii_h),  "LINDO", "UNIT_SEVEN");
        insertCard(db, context.getString(R.string.shinsetsu_k), context.getString(R.string.shinsetsu_h),     "AMABLE", "UNIT_SEVEN");
        insertCard(db, context.getString(R.string.benri_k), context.getString(R.string.benri_h),     "CONVENIENTE", "UNIT_SEVEN");
        insertCard(db, context.getString(R.string.utau_k), context.getString(R.string.utau_h),   "CANTAR", "UNIT_SEVEN");
        insertCard(db, context.getString(R.string.kaburu_k), context.getString(R.string.kaburu_h),       "PONERSE UN SOMRERO", "UNIT_SEVEN");
        insertCard(db, context.getString(R.string.haku_k), context.getString(R.string.haku_h),  "PONERSE COSAS DEBAJO DE LA CINTURA", "UNIT_SEVEN");
        insertCard(db, context.getString(R.string.shiru_k), context.getString(R.string.shiru_h),    "SABER", "UNIT_SEVEN");
        insertCard(db, context.getString(R.string.shitteimasu_k), context.getString(R.string.shitteimasu_h),     "YO SE", "UNIT_SEVEN");
        insertCard(db, context.getString(R.string.shitteimasen_k), context.getString(R.string.shitteimasen_h),    "NO SE", "UNIT_SEVEN");
        insertCard(db, context.getString(R.string.sumu_k), context.getString(R.string.sumu_h),   "VIVIR EN UN LUGAR", "UNIT_SEVEN");
        insertCard(db, context.getString(R.string.hataraku_k), context.getString(R.string.hataraku_h),  "TRABAJAR", "UNIT_SEVEN");
        insertCard(db, context.getString(R.string.futoru_k), context.getString(R.string.futoru_h),     "ENGORDAR", "UNIT_SEVEN");
        insertCard(db, context.getString(R.string.futotteimasu_k), context.getString(R.string.futotteimasu_h),      "TENER SOBREPESO", "UNIT_SEVEN");
        insertCard(db, context.getString(R.string.kakeru_k), context.getString(R.string.kakeru_h),     "PONERSE LENTES", "UNIT_SEVEN");
        insertCard(db, context.getString(R.string.kiru_k), context.getString(R.string.kiru_h),    "PONERSE COSAS ARRIBA DE LA CINTURA", "UNIT_SEVEN");
        insertCard(db, context.getString(R.string.yaseru_k), context.getString(R.string.yaseru_h),    "ADELGASAR", "UNIT_SEVEN");
        insertCard(db, context.getString(R.string.yaseteimasu_k), context.getString(R.string.yaseteimasu_h),  "SER DELGADO", "UNIT_SEVEN");
        insertCard(db, context.getString(R.string.kekkonsuru_k), context.getString(R.string.kekkonsuru_h),  "CASARSE", "UNIT_SEVEN");
        insertCard(db, context.getString(R.string.ga_k), context.getString(R.string.ga_h),      ",PERO", "UNIT_SEVEN");
        insertCard(db, context.getString(R.string.nanimo_k), context.getString(R.string.nanimo_h),   "NADA", "UNIT_SEVEN");
        insertCard(db, context.getString(R.string.nin_k), context.getString(R.string.nin_h),  "[CONTADOR PARA PERSONAS]", "UNIT_SEVEN");
        insertCard(db, context.getString(R.string.hitori_k), context.getString(R.string.hitori_h),"UNA PERSONA", "UNIT_SEVEN");
        insertCard(db, context.getString(R.string.futari_k), context.getString(R.string.futari_h),     "DOS PERSONAS", "UNIT_SEVEN");
        insertCard(db, context.getString(R.string.betsuni_k), context.getString(R.string.betsuni_h),  "NADA EN PARTICULAR", "UNIT_SEVEN");
        insertCard(db, context.getString(R.string.mochiron_k), context.getString(R.string.mochiron_h),"POR SU PUESTO", "UNIT_SEVEN");
        insertCard(db, context.getString(R.string.yokkatara_k), context.getString(R.string.yokkatara_h),     "SI QUIERES", "UNIT_SEVEN");

        db.execSQL("CREATE TABLE UNIT_EIGHT (_id INTEGER PRIMARY KEY AUTOINCREMENT, F_TEXT TEXT, K_TEXT TEXT, B_TEXT TEXT);");
        insertCard(db, "晴れ", "はれ",   context.getString(R.string.hare_e), "UNIT_EIGHT");
        insertCard(db, "雨", "あめ",   context.getString(R.string.ame_e), "UNIT_EIGHT");
        insertCard(db, "曇り", "くもり",   context.getString(R.string.kumori_e), "UNIT_EIGHT");
        insertCard(db, "雪", "ゆき",   context.getString(R.string.yuki_e), "UNIT_EIGHT");
        insertCard(db, "天気予報", "てんきよほう",   context.getString(R.string.tenkiyohou_e), "UNIT_EIGHT");
        insertCard(db, "気温", "きおん",   context.getString(R.string.kion_e), "UNIT_EIGHT");
        insertCard(db, "夏", "なつ",   context.getString(R.string.natsu_e), "UNIT_EIGHT");
        insertCard(db, "冬", "ふゆ",   context.getString(R.string.fuyu_e), "UNIT_EIGHT");
        insertCard(db, "今朝", "けさ",   context.getString(R.string.kesa_e), "UNIT_EIGHT");
        insertCard(db, "あさって", "あさって",   context.getString(R.string.asatte_e), "UNIT_EIGHT");
        insertCard(db, "毎週", "まいしゅう",   context.getString(R.string.maishuu_e), "UNIT_EIGHT");
        insertCard(db, "今月", "こんげつ",   context.getString(R.string.kongetsu_e), "UNIT_EIGHT");
        insertCard(db, "来月", "らいげつ",   context.getString(R.string.raigetsu_e), "UNIT_EIGHT");
        insertCard(db, "会社員", "かいしゃいん",   context.getString(R.string.kaishain_e), "UNIT_EIGHT");
        insertCard(db, "仕事", "しごと",   context.getString(R.string.shigoto_e), "UNIT_EIGHT");
        insertCard(db, "カメラ", "カメラ",   context.getString(R.string.kamera_e), "UNIT_EIGHT");
        insertCard(db, "カラオケ", "カラオケ",   context.getString(R.string.karaoke_e), "UNIT_EIGHT");
        insertCard(db, "所", "ところ",   context.getString(R.string.tokoro_e), "UNIT_EIGHT");
        insertCard(db, "トマト", "トマト",   context.getString(R.string.tomato_e), "UNIT_EIGHT");
        insertCard(db, "はし", "はし",   context.getString(R.string.hashi_e), "UNIT_EIGHT");
        insertCard(db, "パーティー", "パーティー",   context.getString(R.string.paatii_e), "UNIT_EIGHT");
        insertCard(db, "バーベキュー", "バーベキュー",   context.getString(R.string.baabekyuu_e), "UNIT_EIGHT");
        insertCard(db, "ホームステイ", "ホームステイ",   context.getString(R.string.hoomusutei_e), "UNIT_EIGHT");
        insertCard(db, "お風呂", "おふろ",   context.getString(R.string.ofuro_e), "UNIT_EIGHT");
        insertCard(db, "スペイン", "スパイン",   context.getString(R.string.supein_e), "UNIT_EIGHT");
        insertCard(db, "何か", "なにか",   context.getString(R.string.nanika_e), "UNIT_EIGHT");
        insertCard(db, "上手", "じょうず",   context.getString(R.string.jouzu_e), "UNIT_EIGHT");
        insertCard(db, "下手", "へた",   context.getString(R.string.heta_e), "UNIT_EIGHT");
        insertCard(db, "有名", "ゆうめい",   context.getString(R.string.yuumei_e), "UNIT_EIGHT");
        insertCard(db, "洗う", "あらう",   context.getString(R.string.arau_e), "UNIT_EIGHT");
        insertCard(db, "言う", "いう",   context.getString(R.string.iu_e), "UNIT_EIGHT");
        insertCard(db, "いる", "いる",   context.getString(R.string.iru_e), "UNIT_EIGHT");
        insertCard(db, "遅くなる", "おそくなる",   context.getString(R.string.osokunaru_e), "UNIT_EIGHT");
        insertCard(db, "お風呂に入る", "おふろにはいる",   context.getString(R.string.ofuronihairu_e), "UNIT_EIGHT");
        insertCard(db, "思う", "おもう",   context.getString(R.string.omou_e), "UNIT_EIGHT");
        insertCard(db, "切る", "きる",   context.getString(R.string.kiru_e), "UNIT_EIGHT");
        insertCard(db, "作る", "つくる",   context.getString(R.string.tsukuru_e), "UNIT_EIGHT");
        insertCard(db, "降る", "ふる",   context.getString(R.string.furu_e), "UNIT_EIGHT");
        insertCard(db, "持っていく", "もっていく",   context.getString(R.string.motteiku_e), "UNIT_EIGHT");
        insertCard(db, "捨てる", "すてる",   context.getString(R.string.suteru_e), "UNIT_EIGHT");
        insertCard(db, "始める", "はじめる",   context.getString(R.string.hajimeru_e), "UNIT_EIGHT");
        insertCard(db, "運転する", "うんてんする",   context.getString(R.string.untensuru_e), "UNIT_EIGHT");
        insertCard(db, "洗濯する", "せんたくする",   context.getString(R.string.sentakusuru_e), "UNIT_EIGHT");
        insertCard(db, "掃除する", "そうじする",   context.getString(R.string.soujisuru_e), "UNIT_EIGHT");
        insertCard(db, "料理する", "りょうりする",   context.getString(R.string.ryourisuru_e), "UNIT_EIGHT");
        insertCard(db, "うん", "うん",   context.getString(R.string.un_e), "UNIT_EIGHT");
        insertCard(db, "ううん", "ううん",   context.getString(R.string.uun_e), "UNIT_EIGHT");
        insertCard(db, "いつも", "いつも",   context.getString(R.string.itsumo_e), "UNIT_EIGHT");
        insertCard(db, "遅く", "おそく",   context.getString(R.string.osoku_e), "UNIT_EIGHT");
        insertCard(db, "乾杯", "かんぱい",   context.getString(R.string.kanpai_e), "UNIT_EIGHT");
        insertCard(db, "みんなで", "みんなで",   context.getString(R.string.minnade_e), "UNIT_EIGHT");
        insertCard(db, "残念ですね", "ざんねんですね",   context.getString(R.string.zannendesune_e), "UNIT_EIGHT");
        insertCard(db, "まだ", "まだ",   context.getString(R.string.mada_e), "UNIT_EIGHT");
        insertCard(db, "ーについて", "ーについて",   context.getString(R.string.nitsuite_e), "UNIT_EIGHT");
        insertCard(db, "ー度", "ーど",   context.getString(R.string.do_e), "UNIT_EIGHT");
        insertCard(db, "どう", "どう",   context.getString(R.string.dou_e), "UNIT_EIGHT");
}

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {

    }

    public static void insertCard(SQLiteDatabase db, String F_TEXT, String K_TEXT, String B_TEXT, String table){
        int size = (int) DatabaseUtils.queryNumEntries(db, table);
        ContentValues cardValues = new ContentValues();
        cardValues.put("_id", size + 1);
        cardValues.put("F_TEXT", F_TEXT);
        cardValues.put("K_TEXT", K_TEXT);
        cardValues.put("B_TEXT", B_TEXT);

        if (table.equals("Katakana")){
            db.insert("KATAKANA", null, cardValues);
        }else if (table.equals("Unidad 5")){
            db.insert("UNIT_FIVE", null, cardValues);
        }else if (table.equals("Unidad 6")){
            db.insert("UNIT_SIX", null, cardValues);
        }else if (table.equals("Unidad 7")){
            db.insert("UNIT_SEVEN", null, cardValues);
        }else if (table.equals("Unidad 8")){
            db.insert("UNIT_EIGHT", null, cardValues);
        }else{
            db.insert(table, null, cardValues);
        }
    }
}
