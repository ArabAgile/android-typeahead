# android-typeahead
Awesome Android Typeahead library - User mention plugin, UI widget for auto complete user mention using the at sign (@) like Twitter or Facebook.

### Version
1.0.1

### Installation
Awesome Android Typeahead library requires android 4.0.3 (API 15) or above.

#### Using Gradle
- Create 'libraries' directory (if not already exists) in the root of your project at the same level of 'app' directory.
- Extract the 'typeahead.zip' file and move the extracted directory to 'libraries' directory.
Final structure should be as:
  - /app
    - build.gradle
  - /libraries
    - typeahead/
    - build.gradle
  - /settings.gradle

- Edit /settings.gradle ; add the following:
```groovy
include ':typeahead'
project(':typeahead').projectDir = new File('libraries/typeahead')
```
- Edit /app/build.gradle file ; add the following to dependencies section:
```groovy
compile project(':typeahead')
```
- Sync project
- Rebuild project, or run:
```sh
./gradlew assembleDebug
```

For loading remote photos, I'm using [Picasso] library.

## Usage
In your layout, add Add TypeaheadTextView:
```xml
<com.arabagile.typeahead.widget.TypeaheadTextView
    android:id="@+id/typeaheadAutoComplete"
    android:hint="@string/hint_autocomplete"
    android:singleLine="false"
    android:layout_height="wrap_content"
    android:layout_width="match_parent"
    app:ag_threshold="2"
    />
```

Create menu layout for typeahead dropdown menu with name *menu_user_mention.xml* with content:
```xml
<?xml version="1.0" encoding="utf-8"?>
<LinearLayout xmlns:android="http://schemas.android.com/apk/res/android"
    android:orientation="horizontal" android:layout_width="match_parent"
    android:layout_height="wrap_content">
    <ImageView
        android:id="@+id/photo"
        android:layout_width="64dp"
        android:layout_height="64dp"
        android:layout_gravity="center_vertical"
        android:layout_marginRight="10dp"/>
 
    <LinearLayout
        android:layout_width="match_parent"
        android:orientation="vertical"
        android:layout_height="wrap_content"
        android:layout_gravity="center_vertical">
 
        <TextView
            android:id="@+id/fullname"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:textSize="15sp"
            android:layout_weight="1"
            />
 
        <TextView
            android:id="@+id/username"
            android:layout_width="wrap_content"
            android:layout_height="wrap_content"
            android:textSize="12sp"
            android:layout_weight="1"
            />
    </LinearLayout>
</LinearLayout>
```

In your activity, add this sample code:
```java
TypeaheadTextView tvAutoComplete = (TypeaheadTextView) findViewById(R.id.typeaheadAutoComplete);

// Dummy dataset - From Gravatar
List<User> users = new ArrayList<>();
users.add(new User("Arab Agile", "arabagile", "http://www.gravatar.com/avatar/fc58e5bfbdf68ae2d7cc0b145cd27794?s=64"));
users.add(new User("Ammar Basha", "elbasha", "http://gravatar.com/avatar/73883b3fe159213faa5c80e7b5f33ef8?s=65"));
users.add(new User("Mary Angel", "mariana", "http://gravatar.com/avatar/38bc81642c20ff6181f3b39d91829ef8?s=64"));
users.add(new User("Cristina", "cristina", "http://gravatar.com/avatar/55abbae35d82f050bc482aa5b457ce28?s=64"));
users.add(new User("Bob Alexander", "bob", "http://gravatar.com/avatar/d6924c79ed9ba7fdc49c1b591a051c2f?s=64"));

MentionAdapter adapter = new MentionAdapter(this, R.layout.menu_user_mention, users);
 
tvAutoComplete.setAdapter(adapter);
```
Enjoy!

## Configuration
You can set the threshold - the number of charcaters after at sign (@) before the dropdown menu will appear. To do so you can set *ag_threshold* in xml layout to integer value.

## TODO
- Use custom image loader like UIL
 

## License

MIT

[Picasso]:http://square.github.io/picasso/
