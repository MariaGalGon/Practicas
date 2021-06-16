import {html, PolymerElement} from '@polymer/polymer/polymer-element.js';
import '@vaadin/vaadin-ordered-layout/src/vaadin-vertical-layout.js';
import '@vaadin/vaadin-ordered-layout/src/vaadin-horizontal-layout.js';
import './vista-productoaniadido.js';

class VistaListaproductosaniadidos extends PolymerElement {

    static get template() {
        return html`
<style include="shared-styles">
                :host {
                    display: block;
                    height: 100%;
                }
            </style>
<vaadin-horizontal-layout theme="spacing" style="width: 100%; height: 100%; flex-wrap: wrap;" id="lista_productos_aniadidos">
 
</vaadin-horizontal-layout>
`;
    }

    static get is() {
        return 'vista-listaproductosaniadidos';
    }

    static get properties() {
        return {
            // Declare your properties here.
        };
    }
}

customElements.define(VistaListaproductosaniadidos.is, VistaListaproductosaniadidos);
