Webapp.ApplicationAdapter = DS.RESTAdapter.extend({
    namespace: 'api'
});

Webapp.Store = DS.Store.extend({
    adapter: 'Webapp.ApplicationAdapter'
});
