two ways to populate items on `Spinner`

- create array on ``res>values>string.xml``

 ````xml
<resources>
    <string name="app_name">AndroidStudioLab</string>
    <string-array name="planets_array">
        <item>Mercury</item>
        <item>Venus</item>
        <item>Earth</item>
        <item>Mars</item>
        <item>Jupiter</item>
        <item>Saturn</item>
        <item>Uranus</item>
        <item>Neptune</item>
    </string-array>
</resources>
````
and add on ``Spinner``

```xml
<Spinner android:layout_width="wrap_content"
         android:layout_height="wrap_content"
         android:id="@+id/spinner_id"
         android:entries="@array/planets_array"
/>
```

Or using adapter

````java
Spinner spinner = (Spinner) findViewById(R.id.spinner);
// Create an ArrayAdapter using the string array and a default spinner layout
ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
        R.array.planets_array, android.R.layout.simple_spinner_item);
// Specify the layout to use when the list of choices appears
adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
// Apply the adapter to the spinner
spinner.setAdapter(adapter);
````


Simply follow the [developer.android.com/guide](https://developer.android.com/guide/topics/ui/controls/spinner#java)