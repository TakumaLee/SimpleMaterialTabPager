# Simple to create Material Tab with Pager

[App Install](https://play.google.com/store/apps/details?id=com.github.takumalee.simplematerialpager)

# How to import

It requires 14+ API and android support v7 (Toolbar)

## Dependencies
```gradle
repositories {
	jcenter()
}
dependencies {
    compile 'com.github.takumalee:SimpleMaterialTabPager:1.2.0'
}
```

# How to use

### Use Builder Pattern
#### create section
```java
	private SimpleMaterialTabPagerView mPagerView;

	@Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tab_no_action_bar);
        relativeLayout = (RelativeLayout) findViewById(R.id.relative_TabNoActionBarSample);
        mPagerView = new SimpleMaterialTabPagerView.Builder(MTP.DEFAULT)
                .enableActionBar()
                .addSection("1", SuperAwesomeCardFragment.newInstance(1))
                .addSection("2", SuperAwesomeCardFragment.newInstance(2))
                .build(this);

        mPagerView.changeTabTextWithIndicatorColor(Color.WHITE);
        mPagerView.changePrimaryColor(getResources().getColor(android.R.color.holo_blue_bright));
        mPagerView.getToolbar().setTitleTextColor(getResources().getColor(android.R.color.white));
        relativeLayout.addView(mPagerView);
    }
```

#### Xml

```xml
<com.github.takumalee.simplematerialtabpager.view.SimpleMaterialTabPagerView
        android:id="@+id/smtp_pager"
        android:layout_width="match_parent"
        android:layout_height="match_parent"
        app:mtpIsNeedActionBar="true"
        app:mtpTabBackgroundColor="@color/random" />
```

#### onCreate()

```java
private SimpleMaterialTabPagerView mPagerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_xml);
        mPagerView = (SimpleMaterialTabPagerView) findViewById(R.id.smtp_pager);
        // Make adapter to set in pager, and you need to create a new Builder to add section.
        mPagerView.commit(
                new SimpleMaterialTabPagerView.Builder(MTP.DEFAULT)
                        .addSection("1", SuperAwesomeCardFragment.newInstance(1))
                        .addSection("2", SuperAwesomeCardFragment.newInstance(2)));
    }
```

#### Function

```java
public Builder addSection(String title, View view)

public Builder addSection(String title, Fragment fragment)

public Builder addSection(View customTabView, View view)

public Builder addSection(View customTabView, Fragment fragment)

public Builder addSection(int drawableId, View view)

public Builder addSection(int drawableId, Fragment fragment)
``` 

![](http://i.imgur.com/C734q5F.png)



# Developed By

 * Andreas Stuetz - <andreas.stuetz@gmail.com>
 * Check contributors list.
 * Javier Pardo de Santayana Gómez - <jpardogo@gmail.com>

### Credits

 * [Kirill Grouchnikov](https://plus.google.com/108761828584265913206/posts) - Author of [an explanation post on Google+](https://plus.google.com/108761828584265913206/posts/Cwk7joBV3AC)


# License

    Copyright 2013 Andreas Stuetz
    Copyright 2014 Javier Pardo de Santayana Gómez

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

       http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.