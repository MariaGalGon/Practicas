import {html, PolymerElement} from '@polymer/polymer/polymer-element.js';
import '@vaadin/vaadin-ordered-layout/src/vaadin-vertical-layout.js';
import './vista-buscarproducto.js';
import './vista-listaresultadosbusquedaadministrador.js';
import '@vaadin/vaadin-ordered-layout/src/vaadin-horizontal-layout.js';
import '@vaadin/vaadin-text-field/src/vaadin-text-area.js';

class VistaVercatalogoadministrador extends PolymerElement {

    static get template() {
        return html`
<style include="shared-styles">
                :host {
                    display: block;
                    height: 100%;
        			width: 100%;
                }
            </style>
<vaadin-vertical-layout id="vaadinVerticalLayout" style="align-items: stretch; width: 100%; height: 100%;">
 <vaadin-horizontal-layout theme="spacing" id="vaadinHorizontalLayout" style="align-self: stretch; width: 100%;"></vaadin-horizontal-layout>
</vaadin-vertical-layout>
`;
    }

    static get is() {
        return 'vista-vercatalogoadministrador';
    }

    static get properties() {
        return {
            // Declare your properties here.
        };
    }
}

customElements.define(VistaVercatalogoadministrador.is, VistaVercatalogoadministrador);
