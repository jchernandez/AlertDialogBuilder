# AlertDialogBuider

AlertDialogBuilder is a simple implementation of the Android  `android.support.v7.app.AlertDialog.Builder` to simple custumize the `AlertDialog` Buttons.

```java
    AlertDialogBuilder builder = new AlertDialogBuilder(this);
        .title(R.string.title)
        .content(R.string.content)
        .setPositiveButton(R.string.agree,onDialogClickListener)
        .setNegativeButton(R.string.disagree,onDialogClickListener);
```

By the fault it will take your Application `accentColor` to Tint the `positiveButton` but you can change it, also you can change the `negativeButton` and the `neutralButton`.

```java
    AlertDialogBuilder builder = new AlertDialogBuilder(this);
    builder.setNegativeColor(ContextCompat.getColor(context,R.color.negative));
    builder.setNeutralColor(ContextCompat.getColor(context,R.color.neutral));
    builder.setPositiveColor(ContextCompat.getColor(context,R.color.accentColor));
```