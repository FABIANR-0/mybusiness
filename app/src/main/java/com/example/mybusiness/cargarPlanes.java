package com.example.mybusiness;

import android.content.ContentValues;
import android.database.sqlite.SQLiteDatabase;

public class cargarPlanes {

    public void cargar(AdminSQLiteOpenHelper admin,SQLiteDatabase bd){

        ContentValues datoa=new ContentValues();
        String nombre="Plan básico: $16900  cada  mes.";
        String descripciond="Básico: puedes mirar contenidos en un único dispositivo a la vez, bajo calidad estándar, a la vez tambien descargar.";
        datoa.put("descripcion",descripciond);
        datoa.put("codigo",0);
        datoa.put("nombre",nombre);
        datoa.put("precio",16900);
        datoa.put("plat","netflix");
        bd.insert("planesg",null,datoa);

        ContentValues datob=new ContentValues();
        nombre="Plan standard: $26900 mensuales.";
        descripciond="Standard: te permite ver Netflix en un máximo de 2 equipos en simultáneo, en alta definición (HD) siempre que esta opción se encuentre disponible.";
        datob.put("descripcion",descripciond);
        datob.put("codigo",1);
        datob.put("nombre",nombre);
        datob.put("precio",26900);
        datob.put("plat","netflix");
        bd.insert("planesg",null,datob);

        ContentValues datoc=new ContentValues();
        nombre="Plan Premium: $38900 cada mes";
        descripciond="Premium: está pensado para que puedas usar hasta 4 pantallas en alta definición y ultra-alta definición cuando sea posible.";
        datoc.put("descripcion",descripciond);
        datoc.put("codigo",2);
        datoc.put("nombre",nombre);
        datoc.put("precio",38900);
        datoc.put("plat","netflix");
        bd.insert("planesg",null,datoc);

        ContentValues datod=new ContentValues();
        nombre="Plan Top/Prm: $77900 cada mes";
        descripciond="Top premium: se pueden usar hasta 8 pantallas de manera simultanea con calidad full HD, descargas y acceso a todos los juegos.";
        datod.put("descripcion",descripciond);
        datod.put("codigo",3);
        datod.put("nombre",nombre);
        datod.put("precio",79900);
        datod.put("plat","netflix");
        bd.insert("planesg",null,datod);

        ContentValues datoe=new ContentValues();
        nombre="Mini: $3000 por semana 1 cuenta";
        descripciond="Escucha música sin anuncios en tu dispositivo móvil, Disfruta sesiones grupales, Descarga 30 canciones en un dispositivo móvil.";
        datoe.put("descripcion",descripciond);
        datoe.put("codigo",4);
        datoe.put("nombre",nombre);
        datoe.put("precio",3000);
        datoe.put("plat","spotify");
        bd.insert("planesg",null,datoe);

        ContentValues datof=new ContentValues();
        nombre="Individual: $14900 el mes 1 cuenta";
        descripciond="Escucha música sin anuncios, Reproduce tus canciones en cualquier lugar, incluso sin conexión, Reproducción on-demand, Prepaga o suscríbete.";
        datof.put("descripcion",descripciond);
        datof.put("codigo",5);
        datof.put("nombre",nombre);
        datof.put("precio",14900);
        datof.put("plat","spotify");
        bd.insert("planesg",null,datof);

        ContentValues datog=new ContentValues();
        nombre="Duo: $19900 el mes 2 cuentas";
        descripciond="2 cuentas Premium para parejas que conviven, Duo Mix: una lista para dos, actualizada periódicamente con la música que más les gusta, Reproducción de música sin anuncios, sin conexión y on-demand, Prepaga o suscríbete.";
        datog.put("descripcion",descripciond);
        datog.put("codigo",6);
        datog.put("nombre",nombre);
        datog.put("precio",19900);
        datog.put("plat","spotify");
        bd.insert("planesg",null,datog);

        ContentValues datoh=new ContentValues();
        nombre="Familiar: $23900 el mes 6 cuentas";
        descripciond="6 cuentas Premium para familiares que conviven, Mix Familiar: una lista para tu familia, actualizada periódicamente con la música que más les gusta, Bloquea la música explícita, Reproducción de música sin anuncios, sin conexión y on-demand, Prepaga o suscríbete.";
        datoh.put("descripcion",descripciond);
        datoh.put("codigo",7);
        datoh.put("nombre",nombre);
        datoh.put("precio",23900);
        datoh.put("plat","spotify");
        bd.insert("planesg",null,datoh);

        ContentValues datoi=new ContentValues();
        nombre="Xbox Live Gold $32900 el mes";
        descripciond="Como miembro de Xbox Live Gold, tienes acceso a la funcionalidad multijugador más avanzada, juegos adicionales, y descuentos exclusivos para miembros en Microsoft Store. Con Xbox Live Gold, puedes mantenerte conectado con amigos, familiares y miembros de Xbox Live de todo el mundo.";
        datoi.put("descripcion",descripciond);
        datoi.put("codigo",8);
        datoi.put("nombre",nombre);
        datoi.put("precio",32900);
        datoi.put("plat","xbox");
        bd.insert("planesg",null,datoi);

        ContentValues datoj=new ContentValues();
        nombre="Game Pass for Console $29900";
        descripciond="Acceso ilimitado a más de 100 juegos de consola de alta calidad, Agregamos juegos nuevos en todo momento, Xbox Game Studios títulos cuando se estrenen, Ofertas y descuentos para miembros.";
        datoj.put("descripcion",descripciond);
        datoj.put("codigo",9);
        datoj.put("nombre",nombre);
        datoj.put("precio",29900);
        datoj.put("plat","xbox");
        bd.insert("planesg",null,datoj);

        ContentValues datok=new ContentValues();
        nombre="Xbox Game Pass Ultimate $44900";
        descripciond=" Acceso ilimitado a más de 100 juegos de alta calidad en computadora, consola y Android, Agregamos juegos nuevos en todo momento, Xbox Game Studios títulos cuando se estrenen, Ofertas y descuentos para miembros, Ventajas gratuitas exclusivas como contenido en los juegos y ofertas para socios.";
        datok.put("descripcion",descripciond);
        datok.put("codigo",10);
        datok.put("nombre",nombre);
        datok.put("precio",44900);
        datok.put("plat","xbox");
        bd.insert("planesg",null,datok);

        ContentValues datol=new ContentValues();
        nombre="PC Game Pass $29900 el mes.";
        descripciond=" Acceso ilimitado a más de 100 juegos de PC de alta calidad, Agregamos juegos nuevos en todo momento, Xbox Game Studios títulos cuando se estrenen, Ofertas y descuentos para miembros.";
        datol.put("descripcion",descripciond);
        datol.put("codigo",11);
        datol.put("nombre",nombre);
        datol.put("precio",29900);
        datol.put("plat","xbox");
        bd.insert("planesg",null,datol);

        ContentValues datom=new ContentValues();
        nombre="Plan mes Disney Precio $23900";
        descripciond="Suscripción Disney+ Acceso a Todo el contenido Disney+ Suscripcion Mensual Resolución  de 4K y 4 Dispositivos pantallas en simultáneo.";
        datom.put("descripcion",descripciond);
        datom.put("codigo",12);
        datom.put("nombre",nombre);
        datom.put("precio",23900);
        datom.put("plat","disney");
        bd.insert("planesg",null,datom);

        ContentValues daton=new ContentValues();
        nombre="Plan año Disney Precio $239900";
        descripciond="Suscripción Disney+ Acceso a Todo el contenido Disney+ Suscripcion Anual Resolución  de 4K y 4 Dispositivos pantallas en simultáneo.";
        daton.put("descripcion",descripciond);
        daton.put("codigo",13);
        daton.put("nombre",nombre);
        daton.put("precio",239900);
        daton.put("plat","disney");
        bd.insert("planesg",null,daton);

        ContentValues datoo=new ContentValues();
        nombre="Mes Disney + Star Plus $38900";
        descripciond="Suscripción Combo+ Acceso a Todo el contenido Disney+ y Star+ Suscripción Mensual Resolución de 4K y 4 Dispositivos pantallas en simultáneo.";
        datoo.put("descripcion",descripciond);
        datoo.put("codigo",14);
        datoo.put("nombre",nombre);
        datoo.put("precio",38900);
        datoo.put("plat","disney");
        bd.insert("planesg",null,datoo);

        ContentValues datop=new ContentValues();
        nombre="Año Disney + Star Plus $389900";
        descripciond="Suscripción Combo+ Acceso a Todo el contenido Disney+ y Star+ Suscripción Anual Resolución de 4K y 4 Dispositivos pantallas en simultáneo.";
        datop.put("descripcion",descripciond);
        datop.put("codigo",15);
        datop.put("nombre",nombre);
        datop.put("precio",389900);
        datop.put("plat","disney");
        bd.insert("planesg",null,datop);

        ContentValues datoq=new ContentValues();
        nombre="Plan móvil $13900 el mes";
        descripciond="Personaliza tu experiencia creando hasta 5 perfiles distintos por cuenta,crea perfiles para pequeños de acuerdo a contenido para su edad y agregar tus títulos favoritos para verlos cuando quieras todo por un mes.";
        datoq.put("descripcion",descripciond);
        datoq.put("codigo",16);
        datoq.put("nombre",nombre);
        datoq.put("precio",13900 );
        datoq.put("plat","hbo");
        bd.insert("planesg",null,datoq);

        ContentValues dator=new ContentValues();
        nombre="Plan estándar  $19900 el mes";
        descripciond="Personaliza tu experiencia creando hasta 5 perfiles distintos por cuenta,crea perfiles para pequeños de acuerdo a contenido para su edad y agregar tus títulos favoritos para verlos cuando quieras todo por tres meses.";
        dator.put("descripcion",descripciond);
        dator.put("codigo",17);
        dator.put("nombre",nombre);
        dator.put("precio",19900);
        dator.put("plat","hbo");
        bd.insert("planesg",null,dator);

        ContentValues datos=new ContentValues();
        nombre="Plan móvil $37899 tres meses";
        descripciond="Personaliza tu experiencia creando hasta 5 perfiles distintos por cuenta, descarga tus historias preferidas para disfrutar offline donde quieras, crea perfiles para pequeños de acuerdo a contenido para su edad y agregar tus títulos favoritos para verlos cuando quieras vigente por un mes.";
        datos.put("descripcion",descripciond);
        datos.put("codigo",18);
        datos.put("nombre",nombre);
        datos.put("precio",37899);
        datos.put("plat","hbo");
        bd.insert("planesg",null,datos);

        ContentValues datot=new ContentValues();
        nombre="Plan estándar $52900 tres meses";
        descripciond="Personaliza tu experiencia creando hasta 5 perfiles distintos por cuenta, descarga tus historias preferidas para disfrutar offline donde quieras, crea perfiles para pequeños de acuerdo a contenido para su edad y agregar tus títulos favoritos para verlos cuando quieras; vigente por tres meses.";
        datot.put("descripcion",descripciond);
        datot.put("codigo",19);
        datot.put("nombre",nombre);
        datot.put("precio",52900);
        datot.put("plat","hbo");
        bd.insert("planesg",null,datot);

        ContentValues datou=new ContentValues();
        nombre="Plan estandar de un mes $14900";
        descripciond="incluye la licencia para activar el servicio en hasta 3 dispositivos, e incluye calidad de imagen en SD, HD o UHD 4K; Disfruta de títulos Amazon Original exclusivos, además de películas y series populares.";
        datou.put("descripcion",descripciond);
        datou.put("codigo",20);
        datou.put("nombre",nombre);
        datou.put("precio",14900);
        datou.put("plat","amazon");
        bd.insert("planesg",null,datou);

        ContentValues datov=new ContentValues();
        nombre="Plan estandar de 3 meses $40000";
        descripciond="incluye la licencia para activar el servicio en hasta 3 dispositivos, e incluye calidad de imagen en SD, HD o UHD 4K; Disfruta de títulos Amazon Original exclusivos, además de películas y series populares, por un periodo de tres meses.";
        datov.put("descripcion",descripciond);
        datov.put("codigo",21);
        datov.put("nombre",nombre);
        datov.put("precio",40000);
        datov.put("plat","amazon");
        bd.insert("planesg",null,datov);

        ContentValues datow=new ContentValues();
        nombre="Plan exclusivo de un mes $17900";
        descripciond="Lo mejor de la TV sin cortes ni publicidad Una transmisión a demanda de alta resolución; Podrás visualizar distintos programas en calidad 4K UHD, desde hasta 3 pantallas diferentes en la comodidad de tu hogar, sin soportar publicidad ni perder tiempo.";
        datow.put("descripcion",descripciond);
        datow.put("codigo",22);
        datow.put("nombre",nombre);
        datow.put("precio",17900);
        datow.put("plat","amazon");
        bd.insert("planesg",null,datow);

        ContentValues datox=new ContentValues();
        nombre="Plan exclusivo  3 meses $52000";
        descripciond="Lo mejor de la TV sin cortes ni publicidad Una transmisión a demanda de alta resolución; Podrás visualizar distintos programas en calidad 4K UHD, desde hasta 3 pantallas diferentes en la comodidad de tu hogar, sin soportar publicidad ni perder tiempo por tres meses.";
        datox.put("descripcion",descripciond);
        datox.put("codigo",23);
        datox.put("nombre",nombre);
        datox.put("precio",52000);
        datox.put("plat","amazon");
        bd.insert("planesg",null,datox);
    }
}
