# rcat

Tool to print only the replaced results of a regex on a file.

## Syntax
rcat \<regex_pattern\> \<regex_replace_pattern\> \<files...\>

## Example

### example.txt

<pre>
Mario 192.168.0.1 logged in
Mario left
Luigi 192.168.0.1 logged in
Luigi requested file 2
Luigi left
</pre>

### command

`rcat '([^ \n]+) ([0-9A-Fa-f.:]+) logged in\.' 'name: $1, ip_address: $2' text.txt`

### output

<pre>
name: Mario, ip_address: 192.168.0.1
name: Luigi, ip_address: 192.168.0.1
</pre>