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
        db.execSQL("CREATE TABLE UNIT_FIVE (_id INTEGER PRIMARY KEY AUTOINCREMENT, F_TEXT TEXT, B_TEXT TEXT);");
//        insertCard(db, "古い",      "VIEJO", 5);
//        insertCard(db, "天気",      "CLIMA", 5);
//        insertCard(db, "部屋",       "CUARTO", 5);
//        insertCard(db, "好き",       "GUSTAR", 5);
//        insertCard(db, "~枚",       "[CONTADOR PARA OBJETOS PLANOS]", 5);
//        insertCard(db, "暇",       "DESOCUPADO; LIBRE", 5);
//        insertCard(db, "大嫌い",   "ODIAR", 5);
//        insertCard(db, "乗る"    ,   "SUBIRSE A UN VEHICULO", 5);
//        insertCard(db, "L　サイズ",   "TAMAÑO L", 5);
//        insertCard(db, "やる",       "HACER", 5);
//        insertCard(db, "一緒に",    "JUNTOS", 5);
//        insertCard(db, "嫌い",      "DISGUSTAR", 5);
//        insertCard(db, "新しい",  "NUEVO", 5);
//        insertCard(db, "きれい",      "HERMOSO", 5);
//        insertCard(db, "にぎやか",   "CONCURRIDO", 5);
//        insertCard(db, "暑い",      "CALIENTE　(CLIMA)", 5);
//        insertCard(db, "バス",       "AUTOBUS", 5);
//        insertCard(db, "出かける",   "SALIR", 5);
//        insertCard(db, "お土産",    "RECUERDITO", 5);
//        insertCard(db, "難しい", "DIFICIL", 5);
//        insertCard(db, "果物",   "FRUTA", 5);
//        insertCard(db, "すごう",     "EXTREMADAMENTE", 5);
//        insertCard(db, "忙しい",  "OCUPADO", 5);
//        insertCard(db, "熱い",      "CALIENTE　(COSA)", 5);
//        insertCard(db, "サーフィン",     "SURFEAR", 5);
//        insertCard(db, "怖い",      "QUE DA MIEDO", 5);
//        insertCard(db, "テスト",     "EXAMEN", 5);
//        insertCard(db, "面白い",  "INTERESANTE; DIVERTIDO", 5);
//        insertCard(db, "宿題",   "TAREA", 5);
//        insertCard(db, "楽しい",   "DIVERTIDO", 5);
//        insertCard(db, "どんな",      "QUE TIPO DE ...", 5);
//        insertCard(db, "大きい",      "GRANDE", 5);
//        insertCard(db, "大好き",    "AMAR", 5);
//        insertCard(db, "海",        "MAR; PLAYA", 5);
//        insertCard(db, "誕生日",   "CUMPLEAÑOS", 5);
//        insertCard(db, "とても",     "MUY", 5);
//        insertCard(db, "安い",      "BARATO", 5);
//        insertCard(db, "小さい",     "PEQUEÑO", 5);
//        insertCard(db, "静か",    "SILENCIOSO", 5);
//        insertCard(db, "飲み物",   "BEBIDAS", 5);
//        insertCard(db, "泳ぐ",      "NADAR", 5);
//        insertCard(db, "僕",       "YO", 5);
//        insertCard(db, "元気",      "ENERGETICO; SALUDABLE", 5);
//        insertCard(db, "休み",     "VACACIONES; DIA LIBRE", 5);
//        insertCard(db, "旅行",     "VIAJE", 5);
//        insertCard(db, "大丈夫",   "ESTA BIEN", 5);
//        insertCard(db, "食べ物",   "COMIDA", 5);
//        insertCard(db, "聞く",       "PREGUNTAR", 5);
//        insertCard(db, "かっこいい",    "COOL; GUAPO", 5);
//        insertCard(db, "やさしい",   "AMABLE; FACIL", 5);
//        insertCard(db, "つまらない", "ABURRIDO", 5);
//        insertCard(db, "寒い",      "FRIO", 5);

        db.execSQL("CREATE TABLE UNIT_SEVEN (_id INTEGER PRIMARY KEY AUTOINCREMENT, F_TEXT TEXT, K_TEXT TEXT, B_TEXT TEXT);");
//        insertCard(db, "家族",      "FAMILIA", 7);
//        insertCard(db, "おじいさん",      "ABUELO; ANCIANO", 7);
//        insertCard(db, "おばあさん",       "ABUELA; ANCIANA", 7);
//        insertCard(db, "お兄さん",       "HERMANO MAYOR", 7);
//        insertCard(db, "お姉さん",       "HERMANA MAYOR", 7);
//        insertCard(db, "父",       "MI PAPA", 7);
//        insertCard(db, "母",   "MI MAMA", 7);
//        insertCard(db, "兄"    ,   "MI HERMANO MAYOR", 7);
//        insertCard(db, "姉",   "MI HERMANA MAYOR", 7);
//        insertCard(db, "妹",   "HERMANA MENOR", 7);
//        insertCard(db, "弟",       "HERMANO MENOR", 7);
//        insertCard(db, "兄弟",    "HERMANOS Y HERMANAS", 7);
//        insertCard(db, "男の人",      "HOMBRE", 7);
//        insertCard(db, "女の人",  "MUJER", 7);
//        insertCard(db, "会社",      "COMPAÑIA; EMPRESA", 7);
//        insertCard(db, "食堂",   "CAFETERIA; COMEDOR", 7);
//        insertCard(db, "デパート",      "CENTRO COMERCIAL", 7);
//        insertCard(db, "髪",       "CABELLO", 7);
//        insertCard(db, "口",   "BOCA", 7);
//        insertCard(db, "目",    "OJO", 7);
//        insertCard(db, "眼鏡", "LENTES; ANTEOJOS", 7);
//        insertCard(db, "歌",   "CANCION", 7);
//        insertCard(db, "サークル",     "ACTIVIDADES DE CLUB", 7);
//        insertCard(db, "車",  "CARRO", 7);
//        insertCard(db, "長い",      "LARGO", 7);
//        insertCard(db, "短い",     "CORTO", 7);
//        insertCard(db, "速い",      "RAPIDO", 7);
//        insertCard(db, "背が高い",     "ALTO", 7);
//        insertCard(db, "背が低い",  "BAJO; CORTO", 7);
//        insertCard(db, "頭がいい",   "INTELIGENTE", 7);
//        insertCard(db, "かわいい",   "LINDO", 7);
//        insertCard(db, "親切",      "AMABLE", 7);
//        insertCard(db, "便利",      "CONVENIENTE", 7);
//        insertCard(db, "歌う",    "CANTAR", 7);
//        insertCard(db, "かぶる",        "PONERSE UN SOMRERO", 7);
//        insertCard(db, "はく",   "PONERSE COSAS DEBAJO DE LA CINTURA", 7);
//        insertCard(db, "知る",     "SABER", 7);
//        insertCard(db, "知っています",      "YO SE", 7);
//        insertCard(db, "知りません",     "NO SE", 7);
//        insertCard(db, "住む",    "VIVIR EN UN LUGAR", 7);
//        insertCard(db, "働く",   "TRABAJAR", 7);
//        insertCard(db, "太る",      "ENGORDAR", 7);
//        insertCard(db, "太っています",       "TENER SOBREPESO", 7);
//        insertCard(db, "眼鏡をかける",      "PONERSE LENTES", 7);
//        insertCard(db, "着る",     "PONERSE COSAS ARRIBA DE LA CINTURA", 7);
//        insertCard(db, "やせる",     "ADELGASAR", 7);
//        insertCard(db, "やせています",   "SER DELGADO", 7);
//        insertCard(db, "結婚する",   "ESTAR CASADO", 7);
//        insertCard(db, "~が",       ",PERO", 7);
//        insertCard(db, "何も+negativo",    "NADA", 7);
//        insertCard(db, "~人",   "[CONTADOR PARA PERSONAS]", 7);
//        insertCard(db, "一人", "UNA PERSONA", 7);
//        insertCard(db, "二人",      "DOS PERSONAS", 7);
//        insertCard(db, "別に+negativo",   "NADA EN PARTICULAR", 7);
//        insertCard(db, "もちろん", "POR SU PUESTO", 7);
//        insertCard(db, "よかったら",      "SI QUIERES", 7);
}

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
        //db.execSQL("DROP TABLE MONSTER");
        db.execSQL("DROP TABLE UNIT_FIVE");
        db.execSQL("DROP TABLE UNIT_SEVEN");
        updateMyDatabase(db, oldVersion, newVersion);
    }

    private static void insertCard(SQLiteDatabase db, String F_TEXT, String K_TEXT, String B_TEXT, int table){
        ContentValues cardValues = new ContentValues();
        cardValues.put("F_TEXT", F_TEXT);
        cardValues.put("K_TEXT", K_TEXT);
        cardValues.put("B_TEXT", B_TEXT);

        switch (table){
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
        db.execSQL("CREATE TABLE UNIT_FIVE (_id INTEGER PRIMARY KEY AUTOINCREMENT, F_TEXT TEXT, K_TEXT TEXT, B_TEXT TEXT);");
        insertCard(db, "食べ物","たべもの",   "COMIDA", 5);
        insertCard(db, "古い", "ふるい",      "VIEJO", 5);
//        insertCard(db, "天気",      "CLIMA", 5);
//        insertCard(db, "部屋",       "CUARTO", 5);
//        insertCard(db, "好き",       "GUSTAR", 5);
//        insertCard(db, "~枚",       "[CONTADOR PARA OBJETOS PLANOS]", 5);
//        insertCard(db, "暇",       "DESOCUPADO; LIBRE", 5);
//        insertCard(db, "大嫌い",   "ODIAR", 5);
//        insertCard(db, "乗る"    ,   "SUBIRSE A UN VEHICULO", 5);
//        insertCard(db, "L　サイズ",   "TAMAÑO L", 5);
//        insertCard(db, "やる",       "HACER", 5);
//        insertCard(db, "一緒に",    "JUNTOS", 5);
//        insertCard(db, "嫌い",      "DISGUSTAR", 5);
//        insertCard(db, "新しい",  "NUEVO", 5);
//        insertCard(db, "きれい",      "HERMOSO", 5);
//        insertCard(db, "にぎやか",   "CONCURRIDO", 5);
//        insertCard(db, "暑い",      "CALIENTE　(CLIMA)", 5);
//        insertCard(db, "バス",       "AUTOBUS", 5);
//        insertCard(db, "出かける",   "SALIR", 5);
//        insertCard(db, "お土産",    "RECUERDITO", 5);
//        insertCard(db, "難しい", "DIFICIL", 5);
//        insertCard(db, "果物",   "FRUTA", 5);
//        insertCard(db, "そごう",     "EXTREMADAMENTE", 5);
//        insertCard(db, "忙しい",  "OCUPADO", 5);
//        insertCard(db, "熱い",      "CALIENTE　(COSA)", 5);
//        insertCard(db, "サーフィン",     "SURFEAR", 5);
//        insertCard(db, "怖い",      "QUE DA MIEDO", 5);
//        insertCard(db, "テスト",     "EXAMEN", 5);
//        insertCard(db, "面白い",  "INTERESANTE; DIVERTIDO", 5);
//        insertCard(db, "宿題",   "TAREA", 5);
//        insertCard(db, "楽しい",   "DIVERTIDO", 5);
//        insertCard(db, "どんな",      "QUE TIPO DE ...", 5);
//        insertCard(db, "大きい",      "GRANDE", 5);
//        insertCard(db, "大好き",    "AMAR", 5);
//        insertCard(db, "海",        "MAR; PLAYA", 5);
//        insertCard(db, "誕生日",   "CUMPLEAÑOS", 5);
//        insertCard(db, "とても",     "MUY", 5);
//        insertCard(db, "安い",      "BARATO", 5);
//        insertCard(db, "小さい",     "PEQUEÑO", 5);
//        insertCard(db, "静か",    "SILENCIOSO", 5);
//        insertCard(db, "飲み物",   "BEBIDAS", 5);
//        insertCard(db, "泳ぐ",      "NADAR", 5);
//        insertCard(db, "僕",       "YO", 5);
//        insertCard(db, "元気",      "ENERGETICO; SALUDABLE", 5);
//        insertCard(db, "休み",     "VACACIONES; DIA LIBRE", 5);
//        insertCard(db, "旅行",     "VIAJE", 5);
//        insertCard(db, "大丈夫",   "ESTA BIEN", 5);

//        insertCard(db, "聞く",       "PREGUNTAR", 5);
//        insertCard(db, "かっこいい",    "COOL; GUAPO", 5);
//        insertCard(db, "やさしい",   "AMABLE; FACIL", 5);
//        insertCard(db, "つまらない", "ABURRIDO", 5);
//        insertCard(db, "寒い",      "FRIO", 5);

        db.execSQL("CREATE TABLE UNIT_SEVEN (_id INTEGER PRIMARY KEY AUTOINCREMENT, F_TEXT TEXT, K_TEXT TEXT, B_TEXT TEXT);");
        insertCard(db, context.getString(R.string.kazoku_k), context.getString(R.string.kazoku_h),      "FAMILIA", 7);
        insertCard(db, context.getString(R.string.ojiisan_k),context.getString(R.string.ojiisan_h),      "ABUELO; ANCIANO", 7);
        insertCard(db, context.getString(R.string.obaasan_k), context.getString(R.string.obaasan_h),       "ABUELA; ANCIANA", 7);
        insertCard(db, context.getString(R.string.oniisan_k), context.getString(R.string.oniisan_h),       "HERMANO MAYOR", 7);
        insertCard(db, context.getString(R.string.oneesan_k), context.getString(R.string.oneesan_h),       "HERMANA MAYOR", 7);
        insertCard(db, context.getString(R.string.chichi_k), context.getString(R.string.chichi_h),       "MI PAPA", 7);
        insertCard(db, context.getString(R.string.haha_k), context.getString(R.string.haha_h),   "MI MAMA", 7);
        insertCard(db, context.getString(R.string.ani_k), context.getString(R.string.ani_h),   "MI HERMANO MAYOR", 7);
        insertCard(db, "姉", context.getString(R.string.ane_h),   "MI HERMANA MAYOR", 7);
        insertCard(db, "妹", context.getString(R.string.imouto_h),  "HERMANA MENOR", 7);
        insertCard(db, "弟", context.getString(R.string.otouto_h),      "HERMANO MENOR", 7);
        insertCard(db, "兄弟", context.getString(R.string.kyoudai_h),   "HERMANOS Y HERMANAS", 7);
        insertCard(db, "男の人", context.getString(R.string.otokonohito_h),     "HOMBRE", 7);
        insertCard(db, "女の人", context.getString(R.string.onnanohito_h), "MUJER", 7);
        insertCard(db, "会社", context.getString(R.string.kaisha_h),     "COMPAÑIA; EMPRESA", 7);
        insertCard(db, "食堂", context.getString(R.string.shokudou_h),  "CAFETERIA; COMEDOR", 7);
        insertCard(db, "デパート", context.getString(R.string.depaato_h),     "CENTRO COMERCIAL", 7);
        insertCard(db, "髪", context.getString(R.string.kami_h),      "CABELLO", 7);
        insertCard(db, "口", context.getString(R.string.kuchi_h),  "BOCA", 7);
        insertCard(db, "目", context.getString(R.string.me_h),   "OJO", 7);
        insertCard(db, "眼鏡", context.getString(R.string.megane_h),"LENTES; ANTEOJOS", 7);
        insertCard(db, "歌", context.getString(R.string.uta_h),  "CANCION", 7);
        insertCard(db, "サークル", context.getString(R.string.saakuru_h),    "ACTIVIDADES DE CLUB", 7);
        insertCard(db, "車", context.getString(R.string.kuruma_h), "CARRO", 7);
        insertCard(db, "長い", context.getString(R.string.nagai_h),     "LARGO", 7);
        insertCard(db, "短い", context.getString(R.string.mijikai_h),    "CORTO", 7);
        insertCard(db, "速い", context.getString(R.string.hayai_h),     "RAPIDO", 7);
        insertCard(db, "背が高い", context.getString(R.string.segatakai_h),    "ALTO", 7);
        insertCard(db, "背が低い", context.getString(R.string.segahikui_h), "BAJO; CORTO", 7);
        insertCard(db, "頭がいい", context.getString(R.string.atamagaii_h),  "INTELIGENTE", 7);
        insertCard(db, "かわいい", context.getString(R.string.kawaii_h),  "LINDO", 7);
        insertCard(db, "親切", context.getString(R.string.shinsetsu_h),     "AMABLE", 7);
        insertCard(db, "便利", context.getString(R.string.benri_h),     "CONVENIENTE", 7);
        insertCard(db, "歌う", context.getString(R.string.utau_h),   "CANTAR", 7);
        insertCard(db, "かぶる", context.getString(R.string.kaburu_h),       "PONERSE UN SOMRERO", 7);
        insertCard(db, "はく", context.getString(R.string.haku_h),  "PONERSE COSAS DEBAJO DE LA CINTURA", 7);
        insertCard(db, "知る", context.getString(R.string.shiru_h),    "SABER", 7);
        insertCard(db, "知っています", context.getString(R.string.shitteimasu_h),     "YO SE", 7);
        insertCard(db, "知りません", context.getString(R.string.shitteimasen_h),    "NO SE", 7);
        insertCard(db, "住む", context.getString(R.string.sumu_h),   "VIVIR EN UN LUGAR", 7);
        insertCard(db, "働く", context.getString(R.string.hataraku_h),  "TRABAJAR", 7);
        insertCard(db, "太る", context.getString(R.string.futoru_h),     "ENGORDAR", 7);
        insertCard(db, "太っています", context.getString(R.string.futotteimasu_h),      "TENER SOBREPESO", 7);
        insertCard(db, "眼鏡をかける", context.getString(R.string.kakeru_h),     "PONERSE LENTES", 7);
        insertCard(db, "着る", context.getString(R.string.kiru_h),    "PONERSE COSAS ARRIBA DE LA CINTURA", 7);
        insertCard(db, "やせる", context.getString(R.string.yaseru_h),    "ADELGASAR", 7);
        insertCard(db, "やせています", context.getString(R.string.yaseteimasu_h),  "SER DELGADO", 7);
        insertCard(db, "結婚する", context.getString(R.string.kekkonsuru),  "ESTAR CASADO", 7);
        insertCard(db, "~が", context.getString(R.string.ga_h),      ",PERO", 7);
        insertCard(db, "何も+negativo", context.getString(R.string.nanimo_h),   "NADA", 7);
        insertCard(db, "~人", context.getString(R.string.nin_h),  "[CONTADOR PARA PERSONAS]", 7);
        insertCard(db, "一人", context.getString(R.string.hitori_h),"UNA PERSONA", 7);
        insertCard(db, "二人", context.getString(R.string.futari_h),     "DOS PERSONAS", 7);
        insertCard(db, "別に+negativo", context.getString(R.string.betsuni_h),  "NADA EN PARTICULAR", 7);
        insertCard(db, "もちろん", context.getString(R.string.mochiron_h),"POR SU PUESTO", 7);
        insertCard(db, "よかったら", context.getString(R.string.yokkatara),     "SI QUIERES", 7);
    }

    @Override
    public void onOpen (SQLiteDatabase db) {
        //db.execSQL("DROP TABLE MONSTER");
        db.execSQL("DROP TABLE UNIT_FIVE");
        db.execSQL("DROP TABLE UNIT_SEVEN");
        updateMyDatabase(db, 1, 2);
    }
}
