@echo off

cd c:\Users\ronvi_000\Dropbox\Code\java\AppleSeedsBigDataDemo

java -cp .\bin org.ronvis.appleseeds.Example1 .\samples\shakespear\tragedy

echo "press any key to continue..."
pause

java -cp .\bin org.ronvis.appleseeds.Example2 .\samples\shakespear\tragedy 5

echo "press any key to end..."
pause