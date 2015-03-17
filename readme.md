# Simple to create Material Pager
![](http://i.imgur.com/C734q5F.png)

# How to use

## Dependencies
```gradle
	compile 'com.github.takumalee:SimpleMaterialPager:1.0.4'
```

## Usage

1. [`Material Pager no Drawer`](https://github.com/TakumaMochizuki/SimpleMaterialPager#material-pager-no-drawer)
2. [`Material simple toolbar`](https://github.com/TakumaMochizuki/SimpleMaterialPager#material-simple-toolbar)


### Material Pager no Drawer
```
	RelativeLayout relativeLayout;
   	private SimpleMaterialPagerView mPagerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        relativeLayout = (RelativeLayout) findViewById(R.id.relative_Main);

        mPagerView = new SimpleMaterialPagerView(this);
        mPagerView.createNewPage("1", SuperAwesomeCardFragment.newInstance(1));
        mPagerView.createNewPage("2", SuperAwesomeCardFragment.newInstance(2));
        mPagerView.createNewPage("3", SuperAwesomeCardFragment.newInstance(3));
        mPagerView.createNewPage("4", SuperAwesomeCardFragment.newInstance(4));
        mPagerView.setMaterialPagerAdapter();
        
		mPagerView.changeColor(getResources().getColor(android.R.color.holo_red_light));

        relativeLayout.addView(mPagerView);

    }
```

### Material simple toolbar
```

    RelativeLayout relativeLayout;
    private SimpleMaterialBarView mPagerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        relativeLayout = (RelativeLayout) findViewById(R.id.relative_Main);
        mPagerView.changeColor(getResources().getColor(android.R.color.holo_red_light));

        relativeLayout.addView(mPagerView);
    }
```

## Default Tabs Customization

From theme:

* `android:textColorPrimary` value (from your theme) will be applied automatically  to tab's text color , underlineColor, dividerColor and indicatorColor, if any of these values are define in the xml layout.

Notes about some of the native attr:

* `android:textSize` Tab text size
* `android:textColor` Tab text color
* `android:paddingLeft` or `android:paddingRight` Layout padding. Only the biggest of both will be applied to each side.


Custom attr:

 * `pstsIndicatorColor` Color of the sliding indicator
 * `pstsUnderlineColor` Color of the full-width line on the bottom of the view
 * `pstsUnderlineHeight` Height of the full-width line on the bottom of the view
 * `pstsDividerColor` Color of the dividers between tabs
 * `pstsDividerPadding` Top and bottom padding of the dividers
 * `pstsDividerWidth` Stroke width of divider line, defaults to 0
 * `pstsIndicatorHeight`Height of the sliding indicator
 * `pstsTabPaddingLeftRight` Left and right padding of each tab
 * `pstsScrollOffset` Scroll offset of the selected tab
 * `pstsTabBackground` Background drawable of each tab, should be a StateListDrawable
 * `pstsShouldExpand` If set to true, each tab is given the same weight, default false
 * `pstsTextAllCaps` If true, all tab titles will be upper case, default true
 * `pstsPaddingMiddle` If true, the tabs start at the middle of the view (Like Newsstand google app)
 * `pstsTextStyle` Set the text style, default bold
 * `pstsTextSelectedStyle` Set the text style of the selected tab, default bold
 * `pstsTextAlpha` Set the text alpha transparency, default 0.5
 * `pstsTextSelectedAlpha` Set the text alpha transparency of the selected tab, default 1

*Almost all attributes have their respective getters and setters to change them at runtime* , open an issue if you miss any.

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