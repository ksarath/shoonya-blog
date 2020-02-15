***Build***
```
sbt doc
sbt docs/mdoc
sbt docs/docusaurusCreateSite
cd website
yarn install
yarn build
yarn start
```

***Publish***
```
cd website

GIT_USER=USERNAME CURRENT_BRANCH=master USE_SSH=true npm run publish-gh-pages # SSH
# or
GIT_USER=USERNAME CURRENT_BRANCH=master npm run publish-gh-pages # HTTPS
```
