# KIT - Mobile App Development Model Examination
## Part A
1. Activity is an entry point for interacting with a user.
2. Service is the app component that can perform long-running operation in the background
without providing a UI.
3. Fragment is a portion or a behaviour of a UI in an activity.
4. Intent is a messaging object used to request an action from another
app component.
5. ART stands for Android Runtime which is written to run multiple virtual machines
on a low memory device by executing .dex file.
6. To start a new activity from an intent
    ```java
    Intent intent = new Intent(MainActivity.this, NextActivity.class);
    startActivity(intent);
    ``` 
7. Advantages of ConstraintLayout over RelativeLayout is
    * ConstraintLayout is created to solve the problems related on RelativeLayout.
    * ConstraintLayout provides a flexible way to align elements and to resize them at the same time.
8. HAL stands for Hardware Abstraction Layer.
HAL is used to expose device hardware capabilities to the higher layer which is Java API framework.
9. WebView is a view used to display webpages. In android, WebView is mostly used to convert a Wep Application to
Android Application.
10. Broadcast allows android app to send and receive messages from the system and other android apps.
    * An app can receive broadcasts in two way such as via
        * minifest-declared receivers
        * context-register receivers
    * There are two kinds of broadcast which are
        * System Broadcast
        * User-defined Broadcast
## Part B
1. Program to Explain Activity Life Cycle
    * Project Structure
        * main -> MainActivity.java
        * layout -> activity_main.xml
    ```java
    public class MainActivity extends AppCompatActivity{
        @Override
        protected void onCreate(Bundle b){
            super.onCreate(b);
            setContentView(R.layout.activity_main);
            showMessage("Create has been invoked");
        }
        @Override
        protected void onStart(){
            super.onStart();
            showMessage("Start has been invoked");
        }
        @Override
        protected void onResume(){
            super.onResume();
            showMessage("Resume has been invoked");
        }
        @Override
        protected void onPause(){
            super.onPause();
            showMessage("Pause has been invoked");
        }
        @Override
        protected void onStop(){
            super.onStop();
        }
        @Override
        protected void onDestroy(){
            super.onDestroy();
        }
        private void showMessage(String message){
            Toast.makeText(MainActivity.this, message, Toast.LENGTH_SHORT).show();
        }
    }
    ```
2. Program to start different activity on Gesture
    * Project Structure
        * main
            * MainActivity.java
            * OneActivity.java
            * ...
        * layout
            * activity_main.xml
            * activity_one.xml
            * ...
    * Program
        ```java
        public class MainActivity extends AppCompatActivity implements 
                GestureDetector.OnGestureListener,
                GestureDetector.OnDoubleTapListener
        {
            @Override
            protected void onCreate(Bundle b){
                super.onCreate(b);
                setContentView(R.layout.activity_main);
            }
            @Override
            public boolean onDown(MotionEvent m){
                startActivity(new Intent(this, OneActivity.class));
                return true;
            }
            @Override
            public boolean onSingleTapConfirmed(MotionEvent m){
                startActivity(new Intent(this, TwoActivity.class));
                return true;
            }
            @Override
            public boolean onSingleTapUp(MotionEvent m){
                startActivity(new Intent(this, ThreeActivity.class));
                return true;
            }
            @Override
            public void onShowPress(MotionEvent m){
                startActivity(new Intent(this, FourActivity.class));
            }
            @Override
            public void onLongPress(MotionEvent m){
                startActivity(new Intent(this, FiveActivity.class));
            }
            @Override
            public void onPointerCaptureChange(MotionEvent m){
                startActivity(new Intent(this, SixActivity.class));
            }
            @Override
            public boolean onDoubleTap(MotionEvent m){
                startActivity(new Intent(this, SevenActivity.class));
                return true;
            }
            @Override
            public boolean onDoubleTapEvent(MotionEvent m){
                startActivity(new Intent(this, EightActivity.class));
                return true;
            }
            @Override
            public boolean onScroll(MotionEvent m1, MotionEvent m2, Float x, Float y){
                startActivity(new Intent(this, NineActivity.class));
                return true;
            }
            @Override
            public boolean onFling(MotionEvent m1, MotionEvent m2, Float x, FLoat y){
                startActivity(new Intent(this, TenActivity.class));
                return true;
            }
            
        }
        ```    
3. Fragment Life Cycle
    * Diagram
        
        ![alt FragmentLifeCycle](https://developer.android.com/images/fragment_lifecycle.png)
    * Program
        ```java
        public class MainFragment extends Fragment{
            public MainFragment(){}
            @Override
            public void onAttach(Context context){
                super.onAttach(context);
            }
            @Override
            public void onCreate(@Nullable Bundle b){
                super.onCreate(b);
            }
            @Override
            public View onCreateView(LayoutInflator inflator, ViewGroup viewGroup, Bundle b){
                return inflator.inflate(R.layout.fragment_main, viewGroup, flase);
            }
            @Override
            public void onActivityCreate(@Nullable Bundle b){
                super.onActivityCreate(b);
            }
            @Override
            public void onStart(){
                super.onStart();
            }
            @Override
            public void onResume(){
                super.onResume();
            }
            @Override
            public void onPause(){
                super.onPause();
            }
            @Override
            public void onStop(){
                super.onStop();
            }
            @Override
            public void onDestroyView(){
                super.onDestroyView();
            }
            @Override
            public void onDestroy(){
                super.onDestroy();
            }
            @Override
            public void onDetach(){
                super.onDetach();
            }
        }
        ```
4. A program to start a new activity from a button click and send values via intent object
    * activity_main.xml
        ```xml
        <LinearLayout
            android:layout_height="match_parent"
            android:layout_width="match_parent"
            android:orientation="vertical">
            <Button
                android:layout_width="match_parent"
                android:layout_height="wrap_content"
                android:onClick="startNextAct"
                android:text="Click to go to next"/>
        </LinearLayout>
        ```
    * MainActivity.java
```java
public class MainActivity extends AppCompatActivity{
    @Override
    protected void onCreate(Bundle b){
        super.onCreate(b);
        setContentView(R.layout.activity_main);
    }
    public void startNextAct(View view){
        Intent i = new Intent(this, NextActivity.class);
        i.putExtra("token", "fksjlfjsklfjkjfakljfkdjsf");
        startActivity(i);
    }
}
```
5. Advantages and Disadvantages of SQLiteDatabase
    * Advantages
        * light-weight database
        * has zero-configuration
        * by default configured in Android
        * can act as a temporary db 
        * easy for learning and training purpose
    * Disadvantages
        * for normal usage, SQLite is used in low to medium traffic HTTP requestws
        * for android, the data is not shared accross the devices
        * it's by default embeded to android device which is not able
        to be synchronized
        * provide worst user-experience for modern Mobile Application
## Part C
1. Menu
    * Project Structure
        * main
            * MainActivity.java
            * FirstActivity.java
            * SecondActivity.java
        * res
            * layout
                * activity_main.xml
                * activity_first.xml
                * activity_second.xml
            * menu
                * main_menu.xml
    * main_menu.xml
        ```xml
        <menu>
            <item android:id="@+id\first" android:title="First Activity"/>
            <item android:id="@+id\second" android:title="Second Activity"/>
        </menu>
        ```
    * for all the layout, keep the default configured structure
    * SecondActivity and FirstActivity, keep them as the default configuration
    * MainActivity.java
        ```java
        public class MainActivity extends AppCompatActivity{
            @Override
            protected void onCreate(Bunddle b){
                super.onCreate(b);
                setContentView(R.layout.activity_main);
            }
            @Override
            public boolean onCreateOptionsMenu(Menu menu){
                super.onCreateOptionsMenu(menu);
                getMenuInflator().inflate(R.menu.main_menu, menu);
                return true;
            }
            @Overide
            public boolean onOptionsItemSelected(MenuItem item){
                super.onOptionsItemSelected(item);
                switch (item.getItemId()){
                    case R.id.first:
                        startActivity(new Intent(this, FirstActivity.class));
                        break;
                    case R.id.second:
                        startActivity(new Intent(this, SecondActivity.class));
                        break;
                }
                return true;
            }
        }
        ```
2. Generate Alpha Red Green Blue color based on SeekBars
    * main_activity.xml
        ```xml
        <LinearLayout
            android:layout_height="0dp"
            android:layout_width="0dp"
            android:orientation="vertical"
            android:id="@+id/main_layout">
            <SeekBar
                android:layout_height="wrap_content"
                android:layout_width="match_parent"
                android:id="@+id/alpha"/>
            <SeekBar
                    android:layout_height="wrap_content"
                    android:layout_width="match_parent"
                    android:id="@+id/red"/>
            <SeekBar
                    android:layout_height="wrap_content"
                    android:layout_width="match_parent"
                    android:id="@+id/green"/>
            <SeekBar
                    android:layout_height="wrap_content"
                    android:layout_width="match_parent"
                    android:id="@+id/blue"/>
            <Button
                    android:onClick="changeColor"
                    android:layout_width="match_parent"
                    android:layout_height="wrap_content"
                    android:text="Change the Color"/>
        </LinearLayout>
        ```
    * MainActivity.java
        ```java
        public class MainActivity extends AppCompatActivity{
            private LinearLayout mLayout;
            private SeekBar mAlpha, mRed, mGreen, mBlue;
            @Override
            protected void onCreate(Bundle b){
                super.onCreate(b);
                setContentView(R.layout.activity_main);
                mLayout = (LinearLayout) findViewById(R.id.main_layout);
                mAlpha = (SeekBar) findViewById(R.id.alpha);
                mRed = (SeekBar) findViewById(R.id.red);
                mGreen = (SeekBar) findViewById(R.id.green);
                mBlue = (SeekBar) findViewById(R.id.blue);
                mAlpha.setMax(255);
                mRed.setMax(255);
                mGreen.setMax(255);
                mBlue.setMax(255);
            }
            public void changeColor(View view){
                int a = mAlpha.getProgress();
                int r = mRed.getProgress();
                int g = mRed.getProgress();
                int b = mBlue.getProgress();
                int color = Color.argb(a, r, g, b);
                mLayout.setBackgroundColor(color);
            }
        }
        ```
3. Builder Design Pattern
    * Student.java
        ```java
        public class Student{
            int id;
            String name, dob;
            public Student(int id, String name, String dob){
                this.id = id;
                this.name = name;
                this.dob = dob;
            }
            @Override
            public String toString(){
                return id + ") " + name + " DOB: " + dob;
            }
            static class StudentBuilder{
                int id;
                String name, dob;
                StudentBuilder setId(int id){
                    this.id = id;
                    return this;
                }
                StudentBuilder setName(String name){
                    this.name = name;
                    return this;
                }
                StudentBuilder setDob(String dob){
                    this.dob = dob;
                    return this;
                }
                Student getInstance(){
                    return new Student(id, name, email);
                }
                
            }
        }
        ```
    * KitStudent.java
        ```java
        public class KitStudent{
            public static void main(String[] args){
              Student student = new Student.StudentBuilder()
                                        .setId(125)
                                        .setName("Jack")
                                        .getInstance();
              System.out.println(student);
            }
        }
        ```
4. Calculator Project
    * activity_main.xml
        ```xml
        <LinearLayout
            android:layout_width="match_parent"
            android:layout_height="match_parent"
            android:orientation="vertical">
            <EditText
                android:layout_width="match_parent"
                android:layout_height="wrap_content"
                android:id="@+id/first"
                andriod:inputType="number"
                android:hint="0"/>
             <EditText
                android:layout_width="match_parent"
                android:layout_height="wrap_content"
                android:id="@+id/second"
                andriod:inputType="number"
                android:hint="0"/>
            <LinearLayout
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                android:orientation="horizontal">
                <Button
                    android:layout_width="wrap_content"
                    android:layout_height="wrap_content"
                    andorid:layou_weight="1"
                    android:text="+"
                    android:onClick="onSum"/>
                <Button
                    android:layout_width="wrap_content"
                    andorid:layou_weight="1"
                    android:layout_height="wrap_content"
                    android:text="-"
                    android:onClick="onSub"/>
                <Button
                    android:layout_width="wrap_content"
                    android:layout_height="wrap_content"
                    andorid:layou_weight="1"
                    android:text="*"
                    android:onClick="onMulti"/>
                <Button
                    android:layout_width="wrap_content"
                    android:layout_height="wrap_content"
                    andorid:layou_weight="1"
                    android:text="/"
                    android:onClick="onDivide"/>   
                <Button
                    android:layout_width="wrap_content"
                    android:layout_height="wrap_content"
                    andorid:layou_weight="1"
                    android:text="="
                    android:onClick="onEqual"/>                                         
            </LinearLayout>
        </LinearLayout>
        ```   
    * MainActivity.java
        ```java
        public class MainActivity extends AppCompatActivtiy{
            private int symbol, a, b;
            private EditText mFirst, mSecond;
            @Override
            protected void onCreate(Bundle b){
                super.onCreate(b);
                setContentView(R.layout.activity_main);
                mFirst = (EditText) findViewById(R.id.first);
                mSecond = (EditText) findViewById(R.id.second);
                symbol = 0;
                a = b = 0;
            }
            public void onSum(View view){symbol = 1;}
            public void onSub(View view){symbol = 2;}
            public void onMulti(View view){symbol = 3;}
            public void onDivide(View view){symbol = 4;}
            public void onEqual(View view){
                if((mFirst.getText() != null) && (mSecond.getText() != null)){
                    Stirng num1 = mFirst.getText().toString();
                    String num2 = mSecond.getText().toString();
                    if(!(num1.isEmpty() && num2.isEmpty())){
                        a = Integer.parseInt(num1);
                        b = Integer.parseInt(num2);
                        switch (symbol){
                            case 1:
                                showMessage((a + b));
                                break;
                            case 2:
                                showMessage((a - b));
                                break;
                            case 3:
                                showMessage((a * b));
                                break;
                            case 4:
                                showMessage((a / b));
                                break;                       
                        }
                    }
                }
            }
            private voidShowMessage(int result){
                    Toast.makeText(this, "Ans: " + result, Toast.LENGTH_SHORT).show();
            }
        }
        ```
5. Bound Service
    * Explanation
        * A service is bound when an application component binds to it
        by calling bindService();
        * Bound Service offers a client-server interface that allows application
        components to interact with the service
        * Bound Service is also used in IPC (Inter-process communication)
    * Program
        * MyService.java
            ```java
            public class MyService extends Service{
                
                private IBinder iBinder = new LocalBinder();
                public static class LocalBinder extends Binder{
                    public MyService getService(){
                        return MyService.this;
                    }
                }
                
                @Override
                public IBinder onBind(Intent i){
                    return iBinder;
                }
                
                public int sum(int a, int b){
                    return a + b;
                }
            }
            ```   
        * activity_main.xml
            ```xml
            <LinearLayout
                android:layout_width="match_parent"
                android:layout_height="match_parent"
                android:orientation="vertical">
                <Button
                    android:layout_width="wrap_content"
                    android:layout_height="wrap_content"
                    android:onClick="bindMyService"
                    android:text="Bind the Service"
                    />
                <Button
                    android:layout_width="wrap_content"
                    android:layout_height="wrap_content"
                    android:onClick="unBindMyService"
                    android:text="UnBind the Service"
                    />
                <Button
                    android:layout_width="wrap_content"
                    android:layout_height="wrap_content"
                    android:onClick="sumAB"
                    android:text="add 2 numbers"
                    />       
            </LinearLayout>
            ```
        * MainActivity.java
            ```java
            public class MainActivity extends AppCompatActivity{
                private MyService myService;
                private boolean status;
                private ServiceConnection sc = new ServiceConnection(){
                  @Override
                  public void onServiceConnected(ComponentName cn, IBinder iBinder){
                      MyService.LocalBinder binder = (MyService.LocalBinder) iBinder;
                      myService = binder.getService();
                      status = true;
                  }
                  @Override
                  public void onServiceDisconnected(ComponentName componentName){
                      status = false;
                  }
                };
                @Override
                protected void onCreate(Bundle b){
                    super.onCreate(b);
                    setContentView(R.layout.activity_main);
                }
                public void bindMyService(View view){
                    if(!status){
                        Intent i = new Intent(this, MyService.class);
                        bindService(i, sc, Context.BIND_AUTO_CREATE);
                        showMessage("Service is bound");
                    }else showMessage("Please unBind the service first");
                }
                public void unBindMyService(View view){
                    if(status){
                      unbindService(sc);
                      showMessage("Service is unBound");
                    }else showMessage("Please bind the service first");
                }
                public void sumAB(View view){
                    if(status){
                        int result = myService.sum(3, 5);
                        showMessage("Ans: " + result);
                    }else showMessage("Please bind the service first");
                }
                private void showMessage(String message){
                    Toast.makeText(this, message, Toast.LENGTH_LONG).show();
                }
            }
            ```       
6. Multipane Fragments
7. SignUp SignIn with SQLiteDatae
8. Print All Student Details with SQLiteDatabase
    * activity_main.xml
        ```xml
        <LinearLayout
            android:layout_width="match_parent"
            android:layout_height="match_parent"
            android:orientation="vertical">
            <Button
                android:layout_width="wrap_content"
                android:layout_height="wrap_content"
                android:onClick="showDetails"
                android:text="Show Student Details"/>
        </LinearLayout>
        ```
    * SQLiteHelper.java
        ```java
        public class SQLiteHelper extends SQLiteOpenHelper{
            private static final String DB = "kit";
            private static final String TB = "students";
            private static final String COL_1 = "id";
            private static final String COL_2 = "name";
            private static final String COL_3 = "email";
            private int version = 1;
            public SQLiteHelper(Context context){
                super(context, DB, null, version);
            }
            @Override
            public void onCreate(SQLiteDatabase db){
                db.execSQL("CREATE TABLE " + TB + " (" +
                    COL_1 + " INTEGER AUTOINCREMENT PRIMARY KEY, "+
                    COL_2 + " VARCHAR(25) NOT NULL, " +
                    COL_3 + " VARCHAR(100) UNIQUE NOT NULL);"
                );
            }
            @Override
            public void onUpgrade(SQLiteDatabase db, int i, int j){
                db.execSQL("DROP TABLE IF EXISTS " + TB);
                onCreate(db);
            }
            @Override
            public void onDowngrade(SQLiteDatabase db, int i, int j){
                super.onDowngrade(db, i, j);
            }
            Cursor getAllData(){
                SQLiteDatabase db = this.getReadableDatabase();
                return db.rawQuery("SELECT * FROM " + TB);
            }
        }
        ```  
    * MainActivity.java
        ```java
        public class MainActivity extends AppCompatActivity{
            private SQLiteHelper sqLiteHelper;
            
            @Override
            protected void onCreate(Bundle b){
                super.onCreate(b);
                setContentView(R.layout.activity_main);
                sqLiteHelper = new SQLiteHelper(this);
            }
            
            public void showDetails(){
                Cursor res = sqLiteHelper.getAllData();
                StringBuilder s = new StringBuilder();
                if(res.getCount() != 0){
                    while(res.moveToNext()){
                        s.append("Id: ").append(res.getInt(0)).append("\n");
                        s.append("Name: ").append(res.getInt(1)).append("\n");
                        s.append("Email: ").append(res.getInt(2)).append("\n\n");
                    }
                }
                showInfo(s.toString());
            }
            private void showInfo(String message){
                new AlertDialog.Builder(this)
                               .setTitle("All Student Info")
                               .setMessage(message)
                               .setPositiveButton("OK", 
                               new DialogInterface.OnClickListner(){
                                   @Override
                                   public void onClick(DialogInterface d, int i){
                                       d.cancel();
                                   }
                               })
                               .show();
            }
        }
        ```   