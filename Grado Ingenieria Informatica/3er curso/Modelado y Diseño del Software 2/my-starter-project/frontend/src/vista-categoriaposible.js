import {html, PolymerElement} from '@polymer/polymer/polymer-element.js';
import '@vaadin/vaadin-ordered-layout/src/vaadin-horizontal-layout.js';
import '@vaadin/vaadin-checkbox/src/vaadin-checkbox.js';

class VistaCategoriaposible extends PolymerElement {

    static get template() {
        return html`
<style include="shared-styles">
                :host {
                    display: block;
                    height: 100%;
                }
            </style>
<vaadin-horizontal-layout class="content" style="width: 100%; height: 100%;" id="par_categoria_posible">
 <vaadin-checkbox id="checkbox_categoria_posible" style="align-self: center;">
  Categoría
 </vaadin-checkbox>
 <p id="detalles_categoria_posible" style="align-self: center; padding-left: var(--lumo-space-xl);">Detalles</p>
</vaadin-horizontal-layout>
`;
    }

    static get is() {
        return 'vista-categoriaposible';
    }

    static get properties() {
        return {
            // Declare your properties here.
        };
    }
}

customElements.define(VistaCategoriaposible.is, VistaCategoriaposible);
