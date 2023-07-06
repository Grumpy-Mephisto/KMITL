mkdir sub1
cd sub1
echo "" > F11.txt
@REM Another way to create empty file
copy F11.txt F12.txt
mkdir \q2\sub1\sub3
copy F11.txt \sub3\F13.txt
copy F12.txt \q2