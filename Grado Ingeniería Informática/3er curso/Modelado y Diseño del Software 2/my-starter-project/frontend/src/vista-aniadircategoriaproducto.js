import {html, PolymerElement} from '@polymer/polymer/polymer-element.js';
import '@vaadin/vaadin-ordered-layout/src/vaadin-vertical-layout.js';
import './vista-listacategoriasposibles.js';
import '@vaadin/vaadin-ordered-layout/src/vaadin-horizontal-layout.js';
import './vista-buscarcategoria.js';

class VistaAniadircategoriaproducto extends PolymerElement {

    static get template() {
        return html`
<style include="shared-styles">
                :host {
                     display: block;
                    height: 100%;
        			width: 100%;
        			padding: 0px;
                }
            </style>
<vaadin-vertical-layout style="width: 100%; height: 100%;" id="vaadinVerticalLayout">

</vaadin-vertical-layout>
`;
    }

    static get is() {
        return 'vista-aniadircategoriaproducto';
    }

    static get properties() {
        return {
            // Declare your properties here.
        };
    }
}

customElements.define(VistaAniadircategoriaproducto.is, VistaAniadircategoriaproducto);
