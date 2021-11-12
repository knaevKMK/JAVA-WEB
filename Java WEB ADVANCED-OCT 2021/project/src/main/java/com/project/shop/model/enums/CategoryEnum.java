package com.project.shop.model.enums;

import java.util.List;

public enum CategoryEnum {

    PROPERTY("PROPERTIE", List.of("HOUSE","FLAT","LAND","BUSINESS","OFFICE","GARAGE")),
    AUTO("AUTO",List.of("VEHICLE","BUS","TIRE WHEEL","ATV","PRTS & ACCESSORIES","BOATS")),
   ELECTRONIC("ELECTRONIC",List.of("PC","LAPTOP","TABLET","PHONE","PC ACCESSORIES","TV","AUDIO","VIDEO","NAVIGATION","HOME")),
   SPORT_ART("SPORT ADN ART",List.of("GOODS","FILM","TICKETS","FISHING","ANTIQUE","GAMES","BOOKS","MUSIC")),
   PETS("PETS",List.of("DOGS","CATS", "FISH","BIRDS","RABBITS","LOST","OTHER", "FIND NEW HOME", "FIND PARTNER")),
   GARDEN("GARDDEN",List.of("FURNITURE","CURTAINS, CARPETS","CLEANING","CRAFTSMAN","LIGHTS","ART AND DECORATION","BEDROOM", "FOODS, DRINKS", "GARDEN","DISABLED, WHEELCHAIR")),
    FASHION("FASHION",List.of("CLOTHES","SHOES","WATCHES","ACCESSORIES","PERFUME, COSMETICS", "JEWELRY","SEWING SERVICE")),
   BABY("BABY",List.of("CLOTHES","SHOES","STROLLERS","TOYS","FURNITURE","ACCESSORIES","BABYSITTERS, CHILDREN'S CENTERS")),
   VACATION("VACATION",List.of("SUMMER","ON MOUNTAIN","ONE NIGHT","INTERNATIONAL","VILLAGE","SPA")),
    SERVICE("SERVICE",List.of()),
    BUSINESS("BUSINESS",List.of()),
    JOB("JOB",List.of()),
    PRESENT("PRESENT",List.of());


    private List<String> list;

    CategoryEnum(String name,List<String> list) {
      this.list=list;
    }



    public List<String> getList() {
        return list;
    }
}
