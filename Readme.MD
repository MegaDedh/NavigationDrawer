﻿# Пример NavigationDrawer и Navigation

## Navigation Drawer with Navigation Component - Android Studio Tutorial
https://www.youtube.com/watch?v=pucQs0TUe0I

В activity_main.xml делаем root элемент DrawerLayout, и добавляем NavigationView
<details>
  <summary>activity_main.xml</summary> 

```xml
<?xml version="1.0" encoding="utf-8"?>
<androidx.drawerlayout.widget.DrawerLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:id="@+id/drawer_layout"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    android:background="@null"
    android:fitsSystemWindows="true"
    android:focusable="false"
    tools:lcontext=".MainActivity"
    tools:openDrawer="start">

    <fragment
        android:id="@+id/nav_host"
        android:name="androidx.navigation.fragment.NavHostFragment"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        app:defaultNavHost="true"
        app:navGraph="@navigation/nav_graph" />

    <com.google.android.material.navigation.NavigationView
        android:id="@+id/navigationView"
        android:layout_width="wrap_content"
        android:layout_height="match_parent"
        android:layout_gravity="start"
        app:menu="@menu/drawer_menu"/>

    </androidx.drawerlayout.widget.DrawerLayout>
 ```
</details>
 
Настраиваем MainActivity:
<details>
  <summary>MainActivity</summary> 
 
```kotlin
class MainActivity : AppCompatActivity() {

    private lateinit var bind: ActivityMainBinding
    private lateinit var navController: NavController
    private lateinit var appBarConfiguration: AppBarConfiguration

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bind = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bind.root)

        val drawerLayout = bind.drawerLayout
        navController = findNavController(R.id.nav_host)
        bind.navigationView.setupWithNavController(navController)

        appBarConfiguration = AppBarConfiguration(navController.graph, drawerLayout)
        setupActionBarWithNavController(navController, appBarConfiguration)

    }

    override fun onSupportNavigateUp(): Boolean {
        return navController.navigateUp(appBarConfiguration)
    }
}
```
</details>

(!) Если id в menu будут совпадать с id fragment в навигации то будет автоматически создастся навигация из NavigationDrawer
<details>
  <summary>drawer_menu.xml</summary>
 
```xml
<?xml version="1.0" encoding="utf-8"?>
<menu xmlns:android="http://schemas.android.com/apk/res/android">

    <group android:checkableBehavior="single" >
        <item android:title="FragmentStart"
            android:id="@+id/fragment_start"/>
        <item android:title="FragmentOne"
            android:id="@+id/fragment_one"/>
    </group>
 
</menu>
 ```
</details>

<details>
 
  <summary>nav_graph.xml</summary> 
 
```xml
<?xml version="1.0" encoding="utf-8"?>
<navigation xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:id="@+id/nav_graph"
    app:startDestination="@id/fragment_start">


    <!--FragmentStart-->
    <fragment
        android:id="@+id/fragment_start"
        android:name="ru.asshands.softwire.navigationdrawer.FragmentStart"
        android:label="fragment_start"
        tools:layout="@layout/fragment_start">
        <action
            android:id="@+id/action_fragment_start_to_fragment_one"
            app:destination="@id/fragment_one"
            app:enterAnim="@anim/nav_default_enter_anim"
            app:exitAnim="@anim/nav_default_exit_anim"
            app:popEnterAnim="@anim/nav_default_pop_enter_anim"
            app:popExitAnim="@anim/nav_default_pop_exit_anim" />
    </fragment>

    <!--FragmentOne-->
    <fragment
        android:id="@+id/fragment_one"
        android:name="ru.asshands.softwire.navigationdrawer.FragmentOne"
        android:label="fragment_one"
        tools:layout="@layout/fragment_one">
        <action
            android:id="@+id/action_fragment_one_to_fragment_two"
            app:destination="@id/fragment_two"
            app:enterAnim="@anim/nav_default_enter_anim"
            app:exitAnim="@anim/nav_default_exit_anim"
            app:popEnterAnim="@anim/nav_default_pop_enter_anim"
            app:popExitAnim="@anim/nav_default_pop_exit_anim" />
    </fragment>

    <!--FragmentTwo-->
    <fragment
        android:id="@+id/fragment_two"
        android:name="ru.asshands.softwire.navigationdrawer.FragmentTwo"
        android:label="fragment_two"
        tools:layout="@layout/fragment_two">
        <action
            android:id="@+id/action_fragment_two_to_fragment_three"
            app:destination="@id/fragment_three"
            app:enterAnim="@anim/nav_default_enter_anim"
            app:exitAnim="@anim/nav_default_exit_anim"
            app:popEnterAnim="@anim/nav_default_pop_enter_anim"
            app:popExitAnim="@anim/nav_default_pop_exit_anim" />
    </fragment>

    <!--FragmentThree-->
    <fragment
        android:id="@+id/fragment_three"
        android:name="ru.asshands.softwire.navigationdrawer.FragmentThree"
        android:label="fragment_two"
        tools:layout="@layout/fragment_three">

    </fragment>
</navigation>
 ```
</details>

<details>
  <summary>FragmentStart</summary>
 
```kotlin
class FragmentStart  : Fragment(R.layout.fragment_start){

    private var _bind: FragmentStartBinding? = null
    private val bind get() = _bind!!

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        _bind =  FragmentStartBinding.bind(view)

        bind.fragmentText.setOnClickListener {
            findNavController().navigate(R.id.action_fragment_start_to_fragment_one)
        }
    }

    override fun onDestroyView() {
        _bind = null
        super.onDestroyView()
    }
}
 ```
</details>
