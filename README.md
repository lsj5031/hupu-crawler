# Introduction

Hupu admins delete its posts constantly due to censorship. Lots of marvellous sparkling discussions and unique experience got annihilated and lost track permanently. To solve this problem, you can use this tool to download the posts by yourself for your own benefit.

# Requirement

JRE installed and java in your path.

# Build prerequisites

Assuming you are familar with clojure toolchain and you have lein.

# Build
```bash
lein uberjar
```

# Usage

Copy the compiled standalone jar to the desired folder then run

```bash
java -jar YOUR_BUILD_JAR_NAME post-id-1 [post-id-2 ...]
```
Depends on your internet speed, you will see lots of files like "post-id-page-number.html" in your folder soon.
If some of the posts or pages failed because of the anti-crawler mechanism by hupu, don't panic, wait a while and try again. It won't re-download existing files, so it should be fairly fast. 

# Limitation

Given I didn't spent much time on it and I reckon the functionality is decent for now, here are some limitations of this tool. Pull requests are welcome.

No retry after exception
No folder organization yet
No cleanup and reformat yet
No cookies/sessions yet, thus some restricted forums might be out of reach

