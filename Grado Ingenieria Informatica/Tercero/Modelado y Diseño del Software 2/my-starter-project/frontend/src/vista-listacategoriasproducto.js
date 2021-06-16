import {html, PolymerElement} from '@polymer/polymer/polymer-element.js';
import '@vaadin/vaadin-item/src/vaadin-item.js';
import './vista-categoria.js';
import '@vaadin/vaadin-ordered-layout/src/vaadin-horizontal-layout.js';
import '@vaadin/vaadin-button/src/vaadin-button.js';
import '@vaadin/vaadin-ordered-layout/src/vaadin-vertical-layout.js';
import '@vaadin/vaadin-list-box/src/vaadin-list-box.js';
import './vista-categoriaproducto.js';

class VistaListacategoriasproducto extends PolymerElement {

    static get template() {
        return html`
<style include="shared-styles">
                :host {
                    display: block;
                    height: 100%;
        			width: 100%;
                }
            </style>
<vaadin-list-box style="align-self: stretch; width: 100%; flex-grow: 1;" id="lista_categorias_producto">

</vaadin-list-box>
<vaadin-horizontal-layout theme="spacing" id="cuadro_botones" style="width: 100%; height: 100%;">
 <vaadin-button id="boton_aniadir_categoria_producto">
   Añadir 
 </vaadin-button>
 <vaadin-button id="boton_eliminar_categoria_producto">
   Eliminar 
 </vaadin-button>
</vaadin-horizontal-layout>
`;
    }

    static get is() {
        return 'vista-listacategoriasproducto';
    }

    static get properties() {
        return {
            // Declare your properties here.
        };
    }
}

customElements.define(VistaListacategoriasproducto.is, VistaListacategoriasproducto);
