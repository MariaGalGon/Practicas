import {html, PolymerElement} from '@polymer/polymer/polymer-element.js';

import '@vaadin/vaadin-ordered-layout/src/vaadin-vertical-layout.js';
//import './vista-listacaracteristicascibernauta.js';

class VistaVercaracteristicascibernautas extends PolymerElement {

    static get template() {
        return html`
<style include="shared-styles">
                :host {
                    display: block;
                    height: 100%;
                }
            </style>
<vaadin-vertical-layout style="width: 100%; height: 100%;">
 <h3 id="h3"></h3>
 <p id="p"></p>
</vaadin-vertical-layout>
`;
    }

    static get is() {
        return 'vista-vercaracteristicascibernautas';
    }

    static get properties() {
        return {
            // Declare your properties here.
        };
    }
}

customElements.define(VistaVercaracteristicascibernautas.is, VistaVercaracteristicascibernautas);
