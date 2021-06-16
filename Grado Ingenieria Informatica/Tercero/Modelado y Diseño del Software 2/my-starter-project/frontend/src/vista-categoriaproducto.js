import {html, PolymerElement} from '@polymer/polymer/polymer-element.js';
import '@vaadin/vaadin-ordered-layout/src/vaadin-horizontal-layout.js';
import '@vaadin/vaadin-checkbox/src/vaadin-checkbox.js';

class VistaCategoriaproducto extends PolymerElement {

    static get template() {
        return html`
<style include="shared-styles">
                :host {
                    display: block;
                    height: 100%;
        			width: 100%;
                }
            </style>
<vaadin-horizontal-layout id="par_categoria_producto" class="content" style="width: 100%; align-items: center; margin-bottom: var(--lumo-space-m); background-color: #f7f7f7; border-radius: 10px; padding: var(--lumo-space-s);" theme="spacing-xl">
 <vaadin-checkbox id="checkbox_categoria_producto" style="margin-right: var(--lumo-space-m); font-weight: bold; padding-right: var(--lumo-space-l);">

 </vaadin-checkbox>
 <p id="descripcion_categoria_producto" style="align-self: center; padding-left: var(--lumo-space-xl);"></p>
</vaadin-horizontal-layout>
`;
    }

    static get is() {
        return 'vista-categoriaproducto';
    }

    static get properties() {
        return {
            // Declare your properties here.
        };
    }
}

customElements.define(VistaCategoriaproducto.is, VistaCategoriaproducto);
