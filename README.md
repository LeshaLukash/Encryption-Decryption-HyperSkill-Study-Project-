# Encryption-Decryption (HyperSkill Study Project Program)
ENG:
A simple, command-line cipher program that allows a user to encode/decode their data with Caesar cipher.
Works with .txt files.

In order to work you have to provide command-line params (in any order):
  1) -mode: set mode, in which the program will process your data.
    [enc] — encode data //by default
    [dec] — decode data
  2) -key: a integer number that will be used in cipher algorithm. // 0 by default
  3) -data: a text-string that needed to be processed // empty string by default
  4) -in: a path to .txt-file, from which a data will be readed
  5) -out: a path to .txt-file, to which a processed data will be written
  6) -alg:
    ["shift"] — a default algorithm: only letters will be processed, in alphabet diapasone. 
                Numbers and other characters will be ignored.  
    ["unicode"] — alternative algorithm: all characters in data will be shitted without any limits.
    
RUS:
Простая консольная программа для шифрования/дешифрования данных, используя шифр Цезаря.
Работает с .txt-файлами.

Для работы требуется задать программе параметры (в любом порядке):
  1) -mode: устанавливает режим выполнения программы. 
    [enc] — шифровать данные // по умолчанию
    [dec] — расшифровать данные
  2) -key: целое число, которое будет использовано в алгоритме шифрования // 0 по умолчанию
  3) -data: строка текста, которая будет обработана // по умолчанию пустая
  4) -in: путь к .txt-файлу, из которого будут прочитаны данные для обработки
  5) -out: путь к .txt-файлу, в который будут записаны обработанные данные
  6) -alg:
    ["shift"] — алгоритм по умолчанию: обрабатываются только буквы, сдвиг происходит лишь в рамках алфавита. 
                Прочие символы будут проигнорированы
    ["unicode"] — альтернативный алгоритм: будут сдвинуты все символы в данных, без каких-либо ограничений.
    
