@echo off
set/p input=�����ܵ������ַ���:
set/p password=������Կ(��ֵ):
echo ������......
java -cp jasypt-1.9.0.jar org.jasypt.intf.cli.JasyptPBEStringEncryptionCLI input=%input% password=%password% algorithm=PBEWithMD5AndDES
pause