﻿# Уроки-примеры работы с Fragments с STARTANDROID переписаные на Kotlin

## Navigation Drawer with Navigation Component - Android Studio Tutorial
https://www.youtube.com/watch?v=pucQs0TUe0I

!> ```xml
!><?xml version="1.0" encoding="utf-8"?>
!><androidx.drawerlayout.widget.DrawerLayout xmlns:android="http://schemas.android.com/apk/res/android"
!>    xmlns:app="http://schemas.android.com/apk/res-auto"
!>    xmlns:tools="http://schemas.android.com/tools"
!>    android:id="@+id/drawer_layout"
!>    android:layout_width="match_parent"
!>    android:layout_height="match_parent"
!>    android:background="@null"
!>    android:fitsSystemWindows="true"
!>    android:focusable="false"
!>    tools:lcontext=".MainActivity"
!>    tools:openDrawer="start">
!>
!>    <fragment
!>        android:id="@+id/nav_host"
!>        android:name="androidx.navigation.fragment.NavHostFragment"
!>        android:layout_width="match_parent"
!>        android:layout_height="match_parent"
!>        app:defaultNavHost="true"
!>        app:navGraph="@navigation/nav_graph" />
!>
!>
!>    <com.google.android.material.navigation.NavigationView
!>        android:id="@+id/navigationView"
!>        android:layout_width="wrap_content"
!>        android:layout_height="match_parent"
!>        android:layout_gravity="start"
!>        app:menu="@menu/drawer_menu"/>
!>
!>    </androidx.drawerlayout.widget.DrawerLayout>
!> ```