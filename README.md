BlinkLayout
===========

A custom view layout that produces eyestrain and headaches! Something like this:

![BlinkLayout in action!](http://i.imgur.com/JDAYZqV.gif)

Try out the sample application:

<a href="https://play.google.com/store/apps/details?id=com.viewsforandroid.blinklayout.sample">
  <img alt="Get it on Google Play"
       src="http://developer.android.com/images/brand/en_generic_rgb_wo_45.png" />
</a>

Or browse the [source code](https://github.com/ViewsForAndroid/BlinkLayout/tree/master/sample) of the sample application for a complete example of use.

Original post was written in [ViewsForAndroid](http://viewsforandroid.com/archive/2014/06/the-curious-case-of-blinklayout/).

Usage
-----

Put this in your layout:

```xml
<com.viewsforandroid.blinklayout.BlinkLayout
        xmlns:android="http://schemas.android.com/apk/res/android"
        xmlns:tools="http://schemas.android.com/tools"
        xmlns:blink="http://schemas.android.com/apk/res-auto"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        android:paddingLeft="@dimen/activity_horizontal_margin"
        android:paddingRight="@dimen/activity_horizontal_margin"
        android:paddingTop="@dimen/activity_vertical_margin"
        android:paddingBottom="@dimen/activity_vertical_margin"
        blink:blinkRate="250"
        tools:context=".MainAc®tivity$PlaceholderFragment">

    <ImageView
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:src="@drawable/choo_choo_choose_you"
            android:layout_gravity="center"/>

    <TextView
            android:layout_width="match_parent"
            android:layout_height="wrap_content"
            style="@android:style/TextAppearance.Large"
            android:textColor="@android:color/holo_red_dark"
            android:layout_gravity="bottom"
            android:gravity="center"
            android:text="@string/kill_me"/>

</com.viewsforandroid.blinklayout.BlinkLayout>
```

Then cry!

Who's using it
--------------

Are you crazy? Don't. Ever. Edit. This. Readme. To. Put. Your. App. Here.

License
-------

    Copyright 2007 The Android Open Source Project
    Copyright 2014 Aldo Borrero (some stupid minor modifications dude!)

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.
