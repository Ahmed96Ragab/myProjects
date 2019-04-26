package com.cairoguide.ragab.cairoguide;

import android.content.Context;

import java.util.List;

public class Shops {

    public static void initShopsList(List<Location> list, Context context) {

        list.add(new Location(
                context.getString(R.string.shop_Khan_name),
                context.getString(R.string.shop_Khan_description),
                context.getString(R.string.shop_Khan_address),
                context.getString(R.string.shop_Khan_phone),
                context.getString(R.string.shop_Khan_schedule),
                null,
                R.drawable.shop_khan
        ));

        list.add(new Location(
                context.getString(R.string.shop_Festival_name),
                context.getString(R.string.shop_Festival_description),
                context.getString(R.string.shop_Festival_address),
                context.getString(R.string.shop_Festival_phone),
                context.getString(R.string.shop_Festival_schedule),
                null,
                R.drawable.shop_festival
        ));

        list.add(new Location(
                context.getString(R.string.shop_Stars_name),
                context.getString(R.string.shop_Stars_description),
                context.getString(R.string.shop_Stars_address),
                context.getString(R.string.shop_Stars_phone),
                context.getString(R.string.shop_Stars_schedule),
                null,
                R.drawable.shop_stars
        ));

        list.add(new Location(
                context.getString(R.string.shop_Arabia_name),
                context.getString(R.string.shop_Arabia_description),
                context.getString(R.string.shop_Arabia_address),
                context.getString(R.string.shop_Arabia_phone),
                context.getString(R.string.shop_Arabia_schedule),
                null,
                R.drawable.shop_arabia
        ));


    }
}
