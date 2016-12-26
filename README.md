# AlertDialogBuider

[![](https://jitpack.io/v/jchernandez/AlertDialogBuilder.svg)](https://jitpack.io/#jchernandez/AlertDialogBuilder)


AlertDialogBuilder is a simple implementation of the Android  `android.support.v7.app.AlertDialog.Builder` to simple customize the `AlertDialog` Buttons and a customizable `ProgressDialog` that usea the [TintedProgressBar](https://github.com/jchernandez/TintedProgressBar).

# Gradle Dependency

### Repository
The Gradle dependency is available via [JitPack](https://jitpack.io/#jchernandez/AlertDialogBuilder).

Add it in your root build.gradle at the end of repositories:
```gradle
allprojects {
	repositories {
		...
		maven { url "https://jitpack.io" }
	}
}
```

 Add the dependency:
```gradle
    dependencies {
	    compile 'com.github.jchernandez:AlertDialogBuilder:0.1.1'
    }
```

## Usage

The `AlertDialogBuilder` can be use as the Android `AlertDialog` :

```java
    AlertDialogBuilder builder = new AlertDialogBuilder(this);
        .title(R.string.title)
        .setMessage(R.string.message)
        .setPositiveButton(R.string.agree,onDialogClickListener)
        .setNegativeButton(R.string.disagree,onDialogClickListener);
    builder.show();
```

The `AlertProgressBuilder` can be use as the Android `ProgressDialog`:

```java
    AlertProgressBuilder builder = new AlertProgressBuilder(this);
    builder.setMessage("message");
    builder.setTitle("title");
    builder.show();
```


### Customization

### Style

`AlertDialogBuilder` can be styled from the `styles.xml` file:

```xml
 <style name="MyAwesomeStyle" parent="Theme.AppCompat.Light.DarkActionBar">
    <item name="colorPrimary">@color/colorPrimary</item>
    <item name="colorPrimaryDark">@color/colorPrimaryDark</item>
    <item name="colorAccent">@color/colorAccent</item>

    <!--ad_positiveColor used on positive text button color -->
    <item name="ad_positiveColor">#08ff00</item>

    <!--ad_neutralColor used on positive text button color -->
    <item name="ad_neutralColor">#ff0000</item>

    <!--ad_negativeColor used on positive text button color -->
    <item name="ad_negativeColor">#e1a4a4</item>

  <!--   AlertProgressBuilder  --->
  <!-- ProgressBar Dialog Color  --->
    <item name="pb_progressColor">#792e2e</item>
  <!-- ProgressDialog Ttile  --->
    <item name="pb_titleColor">#6ce4a6</item>
  <!-- ProgressDialog Divider  --->
    <item name="pb_dividerColor">#6ce4a6</item>
</style>
```

### Java
By the fault it will take your Application `accentColor` to Tint the `AlertDialogBuilder` `positiveButton` and `AlertProgressBuilder` `Title`, `Divider`and `ProgressBar` divider but you can change it, also you can change the `negativeButton` and the `neutralButton`.

```java
AlertDialogBuilder builder = new AlertDialogBuilder(this);
builder.setNegativeColor(ContextCompat.getColor(context,R.color.negative));
builder.setNeutralColor(ContextCompat.getColor(context,R.color.neutral));
builder.setPositiveColor(ContextCompat.getColor(context,R.color.accentColor));
```

```java
AlertProgressBuilder builder = new AlertProgressBuilder(this);
builder.setMessage("message");
builder.setTitle("title");
builder.setColorProgress(ContextCompat.getColor(this,R.color.colorPrimaryDark));
builder.setTitleColor(ContextCompat.getColor(this, R.color.colorAccent));
builder.setDividerColor(Color.GREEN);builder.show();
```
