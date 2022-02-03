import {html, PolymerElement} from '@polymer/polymer/polymer-element.js';
import '@vaadin/vaadin-ordered-layout/src/vaadin-vertical-layout.js';
import '@vaadin/vaadin-ordered-layout/src/vaadin-horizontal-layout.js';
import './vista-productocomprado.js';
import './vista-productocompra.js';

class VistaListaproductoscomprados extends PolymerElement {

    static get template() {
        return html`
<style include="shared-styles">
                :host {
                    display: block;
                    height: 70%;
                }
            </style>
<vaadin-horizontal-layout class="content" style="flex-wrap: wrap; width: 100%; height: 100%;" theme="spacing" id="lista_productos">
 
</vaadin-horizontal-layout>
`;
    }

    static get is() {
        return 'vista-listaproductoscomprados';
    }

    static get properties() {
        return {
            // Declare your properties here.
        };
    }
}

customElements.define(VistaListaproductoscomprados.is, VistaListaproductoscomprados);
