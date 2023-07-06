@REM Copy F11.txt to sub2 directory with F21.txt name
copy F11.txt \q2\sub2\F21.txt
@REM Copy F12.txt to sub2 directory with F22.txt name
copy F12.txt \q2\sub2\F22.txt
@REM Copy F13.txt to sub2 directory with F23.txt name
copy \sub3\F13.txt \q2\sub2\F23.txt
@REM Change F22.txt name to F22.doc
ren \q2\sub2\F22.txt F22.doc

@REM 1. Relative path
@REM 2. Relative path
@REM 4. Relative path
@REM 5. Absolute path
@REM 6. Absolute path - Relative path
@REM 7. Absolute path - Relative path
@REM 8. Relative path - Absolute path
@REM 9. Relative path - Absolute path
@REM 10. Absolute path - Absolute path
@REM 11. Absolute path - Absolute path

@REM rd /s /q \q2\sub1
@REM del /q \q2\sub2\*.txt